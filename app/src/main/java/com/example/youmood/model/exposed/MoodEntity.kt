package com.example.youmood.model.exposed

import com.example.youmood.model.Activity
import com.example.youmood.model.Mood
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.SizedIterable
import org.jetbrains.exposed.sql.javatime.datetime

object MoodsTable: IntIdTable(name = "MOODS") {
    val mood = varchar("mood", 100)
    val datetime = datetime("datetime")
}

class MoodEntity (
    id: EntityID<Int>,
) : IntEntity(id) {
    companion object: IntEntityClass<MoodEntity>(MoodsTable)
    var mood by MoodsTable.mood
    var dateTime by MoodsTable.datetime
    var activities by ActivityEntity via MoodActivitiesTable

    fun toMood(): Mood {
        return Mood(
            id = this.id.toString().toInt(),
            mood = this.mood.toInt(),
            dateTime = this.dateTime,
            toActivitiesList(activities)
        )
    }

    fun toActivitiesList(iterable: SizedIterable<ActivityEntity>): ArrayList<Activity> {
        val activities = ArrayList<Activity>()
        iterable.forEach {
            activities.add(it.toActivity())
        }
        return activities
    }
}
