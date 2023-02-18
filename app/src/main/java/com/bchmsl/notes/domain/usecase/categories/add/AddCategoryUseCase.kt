package com.bchmsl.notes.domain.usecase.categories.add

import com.bchmsl.notes.data.local.model.Category

interface AddCategoryUseCase {
    suspend fun addCategory(category: Category)
}