package com.bchmsl.notes.domain.usecase.categories.delete

import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.domain.repository.CategoryRepository
import javax.inject.Inject

class DeleteCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
): DeleteCategoryUseCase {
    override suspend fun deleteCategory(category: Category) {
        categoryRepository.removeCategory(category)
    }
}