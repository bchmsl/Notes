package com.bchmsl.notes.domain.usecase.notes.read_all

import com.bchmsl.notes.data.local.model.Note
import kotlinx.coroutines.flow.Flow

interface ReadAllNotesUseCase {
    suspend fun readAllNotes(): Flow<List<Note>>
}