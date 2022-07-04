package com.example.youmood.model.exposed

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime

object MoodsDAO: IntIdTable(name = "MOODS") {
    val mood = integer("mood")
    val datetime = datetime("datetime")
}