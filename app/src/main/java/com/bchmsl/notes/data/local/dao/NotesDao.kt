package com.bchmsl.notes.data.local.dao

import androidx.room.*
import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.data.local.model.Note
import com.bchmsl.notes.data.local.model.relations.CategoryWithNotes

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertNote(note: Note)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCategory(category: Category)

    @Query("SELECT * FROM note")
    suspend fun getAllNotes():List<Note>

    @Query("SELECT * FROM category")
    suspend fun getAllCategories(): List<Category>

    @Transaction
    @Query("SELECT * FROM category WHERE categoryName = :categoryName")
    suspend fun getCategoryWithNotes(categoryName: String): List<CategoryWithNotes>

    @Transaction
    @Query("DELETE FROM note WHERE category = :categoryName")
    suspend fun deleteCategoryNotes(categoryName: String)

    @Delete
    suspend fun deleteNote(note: Note)

    @Delete
    suspend fun deleteCategory(category: Category)
}