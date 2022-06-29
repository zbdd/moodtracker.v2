package com.example.youmood.presentation

import androidx.lifecycle.ViewModel
import com.example.youmood.model.IMoodRepository
import com.example.youmood.model.Mood
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

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