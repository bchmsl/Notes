package com.bchmsl.notes.domain.usecase.notes.read

import com.bchmsl.notes.data.local.model.Note
import com.bchmsl.notes.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ReadNoteUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
): ReadNoteUseCase {
    override suspend fun readNote(note: Note): Flow<Note> {
        return noteRepository.readNote(note)
    }
}