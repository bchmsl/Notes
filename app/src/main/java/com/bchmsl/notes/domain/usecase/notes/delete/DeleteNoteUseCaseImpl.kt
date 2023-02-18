package com.bchmsl.notes.domain.usecase.notes.delete

import com.bchmsl.notes.data.local.model.Note
import com.bchmsl.notes.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
): DeleteNoteUseCase {
    override suspend fun deleteNote(note: Note) {
        noteRepository.removeNote(note)
    }
}