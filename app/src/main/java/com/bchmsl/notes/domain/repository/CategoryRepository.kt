package com.bchmsl.notes.domain.repository

import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.data.local.model.relations.CategoryWithNotes
import kotlinx.coroutines.flow.Flow

interface CategoryRepository {
    suspend fun addCategory(category: Category)
    suspend fun readCategory(category: String): Flow<CategoryWithNotes>
    suspend fun readAllCategories(): Flow<List<Category>>
    suspend fun removeCategory(category: Category)
}