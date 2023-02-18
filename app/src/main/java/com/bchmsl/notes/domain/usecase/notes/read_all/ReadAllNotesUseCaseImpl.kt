package com.bchmsl.notes.domain.usecase.notes.read_all

import com.bchmsl.notes.data.local.model.Note
import com.bchmsl.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ReadAllNotesUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
): ReadAllNotesUseCase {
    override suspend fun readAllNotes(): Flow<List<Note>> {
        return flow {
            noteRepository.readAllNotes().collect{
                emit(it)
            }
        }
    }
}