package com.example.a7ml2.domain.use_case

import com.example.a7ml2.domain.model.Note
import com.example.a7ml2.domain.repository.NoteRepository
import javax.inject.Inject

class AddNoteUseCase @Inject constructor(
    val noteRepository: NoteRepository
) {

    suspend fun addNote(note: Note) = noteRepository.addNote(note)
}