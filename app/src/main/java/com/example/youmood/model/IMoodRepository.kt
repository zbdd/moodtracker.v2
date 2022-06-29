package com.example.youmood.model

interface IMoodRepository {
    fun getData(): ArrayList<Mood>
    fun getAll(): ArrayList<Mood>
}