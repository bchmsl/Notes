package com.bchmsl.notes.data.repository

import com.bchmsl.notes.data.local.database.NotesDatabase
import com.bchmsl.notes.data.local.model.Note
import com.bchmsl.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor(
    private val db: NotesDatabase
): NoteRepository {
    override suspend fun saveNote(note: Note) {
        db.dao.insertNote(note)
    }

    override suspend fun readNote(note: Note): Flow<Note> {
        return flow {
            emit(db.dao.getNote(note.date))
        }
    }

    override suspend fun removeNote(note: Note) {
        db.dao.deleteNote(note)
    }

    override suspend fun readAllNotes(): Flow<List<Note>> {
        return flow {
            emit(db.dao.getAllNotes())
        }
    }
}