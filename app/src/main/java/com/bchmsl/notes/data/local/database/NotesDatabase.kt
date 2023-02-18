package com.bchmsl.notes.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bchmsl.notes.data.local.dao.NotesDao
import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.data.local.model.Note


@Database(
    entities = [Note::class, Category::class],
    version = 1
)
abstract class NotesDatabase: RoomDatabase() {
    abstract val dao: NotesDao
}