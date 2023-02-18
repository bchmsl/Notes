package com.bchmsl.notes.data.repository

import com.bchmsl.notes.data.local.database.NotesDatabase
import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.data.local.model.relations.CategoryWithNotes
import com.bchmsl.notes.domain.repository.CategoryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val db: NotesDatabase
):CategoryRepository {

    override suspend fun addCategory(category: Category) {
        db.dao.insertCategory(category)
    }

    override suspend fun readCategory(category: String): Flow<CategoryWithNotes> {
        return flow{
            emit(db.dao.getCategoryWithNotes(category))
        }
    }

    override suspend fun readAllCategories(): Flow<List<Category>> {
        return flow {
            emit(db.dao.getAllCategories())
        }
    }

    override suspend fun removeCategory(category: Category) {
        db.dao.deleteCategoryNotes(category.categoryName)
        db.dao.deleteCategory(category)
    }

}