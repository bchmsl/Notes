package com.bchmsl.notes.domain.usecase.notes.delete

import com.bchmsl.notes.data.local.model.Note

interface DeleteNoteUseCase {
    suspend fun deleteNote(note:Note)
}