package com.example.youmood.model

/**
 * Main interface defining our core functions required of our repositories
 *
 * @author Zac Durber
 */
interface IBaseRepository {
    fun create(mood: Mood)
    fun readAll(): ArrayList<Mood>
    fun read(id: Int): Mood
    fun update(mood: Mood)
    fun delete(id: Int)
}