package com.example.youmood.model

/**
 * Main interface defining our core functions required of our repositories
 *
 * @author Zac Durber
 */
interface IMoodRepository {
    fun getData(): ArrayList<Mood>
    fun getAll(): ArrayList<Mood>
}