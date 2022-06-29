package com.example.youmood.presentation

import androidx.lifecycle.ViewModel
import com.example.youmood.model.IMoodRepository
import com.example.youmood.model.Mood
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * MainViewModel class to handle the business logic of Mood entries and
 * the state of the associated MainView UI
 * Must implement its interface IMainViewModel
 *
 * @author Zac Durber
 * @param moodRepository adhering to interface IMoodRepository
 */
@HiltViewModel
class MainViewModel @Inject constructor(val moodRepository: IMoodRepository): IMainViewModel,
    ViewModel() {

    init {
        moodRepository.getData()
    }

    override fun onViewCreated() {
        TODO("Not yet implemented")
    }

     fun onDestroy() {
        TODO("Not yet implemented")
    }

    override fun getMoodList(): MutableList<Mood> {
        return moodRepository.getAll()
    }
}