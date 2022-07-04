package com.example.youmood.model.exposed

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime

/**
 * DAO for the Moods Table
 *
 * @author Zac Durber
 */

object MoodsDAO: IntIdTable(name = "MOODS") {
    val mood = integer("mood")
    val datetime = datetime("datetime")
}