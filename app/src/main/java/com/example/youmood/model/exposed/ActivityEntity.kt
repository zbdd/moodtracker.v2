package com.example.youmood.model.exposed

import com.example.youmood.model.Activity
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable

object ActivitiesTable: IntIdTable(name = "ACTIVITIES") {
    val name = varchar("name", 100)
}

class ActivityEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<ActivityEntity>(ActivitiesTable)
    var name by ActivitiesTable.name

    fun toActivity(): Activity {
        return Activity(this.id.toString().toInt(),
        this.name)
    }
}

/**
 * Intermediate table to connect an Activity to a Mood
 */
object MoodActivitiesTable: IntIdTable(name = "MOOD_ACTIVITIES") {
    val moodId = reference("MOODS", MoodsTable)
    val activityId = reference ("ACTIVITIES", ActivitiesTable)
}