package com.example.youmood.model.exposed

import org.jetbrains.exposed.dao.id.IntIdTable

object ActivitiesDAO: IntIdTable(name = "ACTIVITIES") {
    val name = varchar("name", 100)
}