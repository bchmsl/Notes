package com.bchmsl.notes.presentation.home

import androidx.lifecycle.ViewModel
import com.bchmsl.notes.common.extensions.async
import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.domain.usecase.categories.read_all.ReadAllCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val readAllCategoriesUseCase: ReadAllCategoriesUseCase,
) : ViewModel() {

    private val _categoriesState = MutableSharedFlow<List<Category>>()
    val categoriesState = _categoriesState.asSharedFlow()

    fun getAllCategories() {
        async(IO) {
            readAllCategoriesUseCase.readAllCategories().collect { categories ->
                _categoriesState.emit(categories)
            }
        }
    }

}