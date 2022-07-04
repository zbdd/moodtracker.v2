package com.example.youmood.model.exposed

import org.jetbrains.exposed.dao.id.IntIdTable

/**
 * DAO for the Activities Table
 *
 * @author Zac Durber
 */
object ActivitiesDAO: IntIdTable(name = "ACTIVITIES") {
    val name = varchar("name", 100)
}