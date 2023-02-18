package com.bchmsl.notes.domain.usecase.notes.add

import com.bchmsl.notes.data.local.model.Note
import com.bchmsl.notes.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCaseImpl @Inject constructor(
    private val noteRepository: NoteRepository
) : AddNoteUseCase {
    override suspend fun addNote(note: Note) {
        noteRepository.saveNote(note)
    }
}