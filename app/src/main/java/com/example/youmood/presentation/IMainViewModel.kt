package com.example.youmood.presentation

import com.example.youmood.model.Mood

/**
 * Main interface for defining the required properties and functions of MainViewModel
 *
 * @author Zac Durber
 */

interface IMainViewModel {
    fun onViewCreated()
    fun getMoodList(): MutableList<Mood>
}