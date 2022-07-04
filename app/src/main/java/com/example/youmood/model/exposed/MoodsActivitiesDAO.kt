package com.example.youmood.model.exposed

import org.jetbrains.exposed.dao.id.IntIdTable


/**
 * Intermediate table to connect an Activity to a Mood
 *
 * @author Zac Durber
 */
object MoodsActivitiesDAO: IntIdTable(name = "MOODS_ACTIVITIES") {
    val moodId = reference("MOODS", MoodsDAO)
    val activityId = reference ("ACTIVITIES", ActivitiesDAO)
}