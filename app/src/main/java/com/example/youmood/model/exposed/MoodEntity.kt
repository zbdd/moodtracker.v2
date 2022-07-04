package com.example.youmood.model.exposed

import com.example.youmood.model.Activity
import com.example.youmood.model.Mood
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.sql.SizedIterable

/**
 * Entity to map calls to and from our database
 *
 * @param id primary key for this row
 * @author Zac Durber
 */

class MoodEntity (
    id: EntityID<Int>,
) : IntEntity(id) {
    companion object: IntEntityClass<MoodEntity>(MoodsDAO)
    var mood by MoodsDAO.mood
    var dateTime by MoodsDAO.datetime
    var activities by ActivityEntity via MoodsActivitiesDAO

    /**
     * func to convert Entity to its appropriate data class
     */
    fun toMood(): Mood {
        return Mood(
            id = this.id.toString().toInt(),
            mood = this.mood,
            dateTime = this.dateTime,
            toActivitiesList(activities)
        )
    }

    /**
     * func to convert Entity to its appropriate data class
     */
    fun toActivitiesList(iterable: SizedIterable<ActivityEntity>): ArrayList<Activity> {
        val activities = ArrayList<Activity>()
        iterable.forEach {
            activities.add(it.toActivity())
        }
        return activities
    }
}
