package com.example.youmood.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.youmood.model.Mood
import com.example.youmood.presentation.IMainViewModel
import com.example.youmood.ui.theme.YouMoodTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity @Inject constructor() : ComponentActivity(), IMainView {
    @Inject lateinit var viewModel: IMainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            YouMoodTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    displayList(viewModel.getMoodList())
                }
            }
        }
    }

    @Composable
    fun displayList(moodList: MutableList<Mood>) {
        LazyColumn() {
            items(moodList) {
                mood -> displayMoodRow(mood)
            }
        }
    }

    @Composable
    fun displayMoodRow(mood: Mood) {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
        Text(text = mood.mood.toString())
        Text(text = formatter.format(mood.dateTime))
    }
}