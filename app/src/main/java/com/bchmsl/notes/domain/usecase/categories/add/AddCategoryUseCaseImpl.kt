package com.bchmsl.notes.domain.usecase.categories.add

import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.domain.repository.CategoryRepository
import javax.inject.Inject

class AddCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
): AddCategoryUseCase {
    override suspend fun addCategory(category: Category) {
        categoryRepository.addCategory(category)
    }
}