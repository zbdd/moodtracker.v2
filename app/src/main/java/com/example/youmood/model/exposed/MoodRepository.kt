package com.example.youmood.model.exposed

import androidx.lifecycle.MutableLiveData
import com.example.youmood.model.IMoodRepository
import com.example.youmood.model.Mood
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.TransactionManager
import org.jetbrains.exposed.sql.transactions.transaction
import java.sql.Connection
import java.time.LocalDateTime
import javax.inject.Inject

/**
 * Mood repository build upon the Exposed framework
 *
 * @author Zac Durber
 */
class MoodRepository @Inject constructor(): IMoodRepository {
    init {
        Database.connect("jdbc:h2:mem:db_name_test;MODE=MSSQLServer;DB_CLOSE_ON_EXIT=FALSE;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS db_name_test", driver = "org.h2.Driver")
        TransactionManager.manager.defaultIsolationLevel =
            Connection.TRANSACTION_SERIALIZABLE

        runBlocking {
            withContext(Dispatchers.IO) {
                transaction {
                    SchemaUtils.create(MoodsTable, ActivitiesTable, MoodActivitiesTable)
                }
            }
        }

            val mood1 = transaction { MoodEntity.new {
                mood = "3"
                dateTime = LocalDateTime.now()
            } }
            val activity1 = transaction {
                ActivityEntity.new {
                    name = "High jump"
                }
            }
        val activity2 = transaction {
            ActivityEntity.new {
                name = "Programming"
            }
        }
            transaction {
                MoodActivitiesTable.insert {
                    it[moodId] = mood1.id
                    it[activityId] = activity1.id
                }
            }
            transaction {
                MoodActivitiesTable.insert {
                    it[moodId] = mood1.id
                    it[activityId] = activity2.id
                }
            }
    }
    var moodList = MutableLiveData<ArrayList<Mood>>()

    /**
     * Test data for simulating a call to local storage
     * @return a list of Moods
     */
    override fun readAll(): ArrayList<Mood>{
        val returnArray = ArrayList<Mood>()
        transaction {
            MoodEntity.all().forEach { returnArray.add(it.toMood()) }
        }
        return returnArray
    }

    override fun create(mood: Mood) {
        TODO("Not yet implemented")
    }

    override fun read(id: Int): Mood {
        TODO("Not yet implemented")
    }

    override fun update(mood: Mood) {
        TODO("Not yet implemented")
    }

    override fun delete(id: Int) {
        TODO("Not yet implemented")
    }

    /**
     * Retrieve one Mood entry from the repository
     *
     * @return a mood entry
     */
     fun get(id: Int): Mood? {
        return MoodEntity.findById(id)?.toMood()
    }
}
