package com.example.youmood.model

/**
 * Main interface defining our core functions required of our repositories
 *
 * @author Zac Durber
 */
interface IBaseRepository<T> {
    fun create(obj: T)
    fun readAll(): ArrayList<T>
    fun read(id: Int): T?
    fun update(obj: T)
    fun delete(id: Int): Boolean
}