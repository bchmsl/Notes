package com.bchmsl.notes.domain.usecase.categories.read_all

import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReadAllCategoriesUseCaseImpl @Inject constructor(
    private val categoryRepository: CategoryRepository
) : ReadAllCategoriesUseCase {
    override suspend fun readAllCategories(): Flow<List<Category>> {
        return flow {
            categoryRepository.readAllCategories().collect{
                emit(it)
            }
        }
    }
}