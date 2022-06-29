package com.example.youmood.model

import dagger.Module
import java.time.LocalDateTime
import javax.inject.Inject

data class Mood @Inject constructor(
    val Id: Int,
    val mood: Int,
    val dateTime: LocalDateTime
)