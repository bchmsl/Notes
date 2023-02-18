package com.bchmsl.notes.domain.usecase.categories.read_all

import com.bchmsl.notes.data.local.model.Category
import kotlinx.coroutines.flow.Flow

interface ReadAllCategoriesUseCase {
    suspend fun readAllCategories(): Flow<List<Category>>
}