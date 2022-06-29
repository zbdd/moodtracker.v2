package com.example.youmood.model

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.android.volley.RequestQueue
import java.time.LocalDateTime
import javax.inject.Inject

/**
 * Main repository class to abstract away the underlying database implementation
 *
 * @author Zac Durber
 */
class MoodRepository @Inject constructor(): IMoodRepository {
    var moodsList = MutableLiveData<ArrayList<Mood>>()

    /**
     * Test data for simulating a call to local storage
     * @return a list of Moods
     */
    override fun getData(): ArrayList<Mood>{
        val list = ArrayList<Mood>();
        list.add(Mood(1,1, LocalDateTime.now()))
        list.add(Mood(2,3, LocalDateTime.now().minusDays(1)))
        list.add(Mood(3,2, LocalDateTime.now().minusDays(2)))
        list.add(Mood(4,5, LocalDateTime.now().minusDays(3)))

        return list
    }

    /**
     * Retrieve one Mood entry from the repository
     *
     * @return a mood entry
     */
     fun get(): Mood {
        return Mood(6,6, LocalDateTime.now())
    }

    /**
     * Get all Mood entries from the repository
     *
     * @return an arraylist of Moods
     */
     override fun getAll(): ArrayList<Mood> {
        return getData()
    }
}