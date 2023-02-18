package com.bchmsl.notes.domain.usecase.notes.read

import com.bchmsl.notes.data.local.model.Note
import kotlinx.coroutines.flow.Flow

interface ReadNoteUseCase {
    suspend fun readNote(note: Note): Flow<Note>
}