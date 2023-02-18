package com.bchmsl.notes.domain.usecase.categories.read

import com.bchmsl.notes.data.local.model.relations.CategoryWithNotes
import kotlinx.coroutines.flow.Flow

interface ReadCategoryUseCase {
    suspend fun readCategory(category:String): Flow<CategoryWithNotes>
}