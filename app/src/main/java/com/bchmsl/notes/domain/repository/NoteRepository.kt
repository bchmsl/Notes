package com.bchmsl.notes.domain.repository

import com.bchmsl.notes.data.local.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun saveNote(note: Note)
    suspend fun readNote(note: Note): Flow<Note>
    suspend fun removeNote(note: Note)
    suspend fun readAllNotes(): Flow<List<Note>>
}