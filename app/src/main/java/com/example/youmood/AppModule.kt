package com.example.youmood

import com.example.youmood.model.IMoodRepository
import com.example.youmood.model.exposed.MoodRepository
import com.example.youmood.presentation.IMainViewModel
import com.example.youmood.presentation.MainViewModel
import com.example.youmood.view.IMainView
import com.example.youmood.view.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


/**
 * Class AppModule required for instantiating our dependency injections for Hilt
 *
 * @author Zac Durber
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    fun providesMoodRepository(): IMoodRepository = MoodRepository()

    @Singleton
    @Provides
    fun providesMainViewModel(moodRepository: IMoodRepository): IMainViewModel = MainViewModel(moodRepository)

    @Provides
    fun providesMainView(mainViewModel: IMainViewModel): IMainView = MainActivity()
}