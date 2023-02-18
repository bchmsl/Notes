package com.bchmsl.notes.domain.usecase.categories.read

import com.bchmsl.notes.data.local.model.relations.CategoryWithNotes
import com.bchmsl.notes.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadCategoryUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
): ReadCategoryUseCase {
    override suspend fun readCategory(category:String): Flow<CategoryWithNotes> {
        return categoryRepository.readCategory(category)
    }
}