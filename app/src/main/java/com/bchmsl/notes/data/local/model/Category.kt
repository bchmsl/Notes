package com.bchmsl.notes.data.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Category(
    @PrimaryKey(autoGenerate = false)
    val categoryName: String
)