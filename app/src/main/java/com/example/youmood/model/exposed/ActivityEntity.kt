package com.example.youmood.model.exposed

import com.example.youmood.model.Activity
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

/**
 * Entity to map calls to and from our database
 *
 * @param id primary key for this row
 * @author Zac Durber
 */
class ActivityEntity(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<ActivityEntity>(ActivitiesDAO)
    var name by ActivitiesDAO.name

    /**
     * Map each individual ActivityEntity to its core data class
     */
    fun toActivity(): Activity {
        return Activity(this.id.toString().toInt(),
        this.name)
    }
}
