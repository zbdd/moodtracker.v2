package com.example.youmood.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
                    //displayList(viewModel.getMoodList())
                    showList()
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
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
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
        Row (modifier = Modifier
            .background(Color.DarkGray, shape = RoundedCornerShape(15.dp))
            .fillMaxWidth()
            .padding(all = 15.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly) {
            Text(text = formatter.format(mood.dateTime), color = MaterialTheme.colors.primary)
            Text(text = mood.mood.toString(), color = MaterialTheme.colors.primary, fontWeight = FontWeight.Bold)
            mood.activities.indices.forEach {
                var separator = ""
                if (it > 0) separator = ","
                Text(text = separator + mood.activities[it].name.trim())
            }
        }
    }

    @Preview
    @Composable
    fun showList() {
        displayList(viewModel.getMoodList())
    }
}