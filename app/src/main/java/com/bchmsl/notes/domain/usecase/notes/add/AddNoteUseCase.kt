package com.bchmsl.notes.domain.usecase.notes.add

import com.bchmsl.notes.data.local.model.Note

interface AddNoteUseCase {
    suspend fun addNote(note: Note)
}