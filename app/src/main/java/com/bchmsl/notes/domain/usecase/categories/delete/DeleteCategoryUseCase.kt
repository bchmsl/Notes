package com.bchmsl.notes.domain.usecase.categories.delete

import com.bchmsl.notes.data.local.model.Category

interface DeleteCategoryUseCase {
    suspend fun deleteCategory(category: Category)
}