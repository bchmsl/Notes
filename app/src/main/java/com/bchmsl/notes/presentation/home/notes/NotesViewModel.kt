package com.bchmsl.notes.presentation.home.notes

import androidx.lifecycle.ViewModel
import com.bchmsl.notes.common.extensions.async
import com.bchmsl.notes.data.local.model.Note
import com.bchmsl.notes.domain.usecase.categories.read.ReadCategoryUseCase
import com.bchmsl.notes.domain.usecase.notes.read_all.ReadAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class NotesViewModel @Inject constructor(
    private val readCategoryUseCase: ReadCategoryUseCase,
    private val readAllNotesUseCase: ReadAllNotesUseCase,
) : ViewModel() {

    private val _notesState = MutableSharedFlow<List<Note>>()
    val notesState = _notesState.asSharedFlow()

    fun getNotesByCategory(category: String) {
        async(IO) {
            readCategoryUseCase.readCategory(category).collect { notes ->
                _notesState.emit(notes.notes)
            }
        }
    }

    fun getAllNotes() {
        async(IO) {
            readAllNotesUseCase.readAllNotes().collect { notes ->
                _notesState.emit(notes)
            }
        }
    }
}