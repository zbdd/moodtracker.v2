package com.example.youmood.model

import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime
import java.time.LocalDateTime
import javax.inject.Inject

/**
 * Data class for the most basic unit type in this project
 * the Mood record of a person at a point in time
 *
 * @author Zac Durber
 */
data class Mood (
    var id: Int,
    var mood: Int,
    var dateTime: LocalDateTime,
    var activities: ArrayList<Activity>
    )