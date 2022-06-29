package com.example.youmood.presentation

import com.example.youmood.model.Mood

interface IMainViewModel {
    fun onViewCreated()
    fun getMoodList(): MutableList<Mood>
}