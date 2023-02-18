package com.bchmsl.notes.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Note(
    @PrimaryKey(autoGenerate = false)
    val date: Int,
    val title: String,
    val body: String,
    val category: String
)