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
import com.example.youmood.view.theme.YouMoodTheme
import dagger.hilt.android.AndroidEntryPoint
import java.time.format.DateTimeFormatter
import java.util.*
import javax.inject.Inject

/**
 * Primary view when the app loads - displays a scrollable list of Moods
 * Has to implement all items declared in interface IMainView
 *
 * @author Zac Durber
 */
@AndroidEntryPoint
class MainActivity @Inject constructor() : ComponentActivity(), IMainView {
    @Inject lateinit var viewModel: IMainViewModel

    /**
     * Runs on Activity creation and renders a surface container which we then
     * begin to fill-in with Composable items
     *
     * @param savedInstanceState Not touching this bundle
     */
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

    /**
     * Render us a list and call the next function to define the look of each Mood
     * @param moodList an arraylist of Mood provided by our ViewModel
     */
    @Composable
    fun displayList(moodList: MutableList<Mood>) {
        LazyColumn() {
            items(moodList) {
                mood -> displayMoodRow(mood)
            }
        }
    }

    /**
     * Render each Mood row nicely in the list
     * @param mood an instance of our Mood model
     */
    @Composable
    fun displayMoodRow(mood: Mood) {
        val formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy", Locale.ENGLISH)
        Text(text = mood.mood.toString())
        Text(text = formatter.format(mood.dateTime))
    }
}