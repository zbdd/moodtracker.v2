package com.example.youmood.model

import java.time.LocalDateTime
import javax.inject.Inject

/**
 * Data class for the most basic unit type in this project
 * the Mood record of a person at a point in time
 *
 * @author Zac Durber
 */
data class Mood @Inject constructor(
    val Id: Int,
    val mood: Int,
    val dateTime: LocalDateTime,
    val activities: ArrayList<Int>
)