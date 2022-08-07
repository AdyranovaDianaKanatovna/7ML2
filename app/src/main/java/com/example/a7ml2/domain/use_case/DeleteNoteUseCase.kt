package com.example.a7ml2.domain.use_case

import com.example.a7ml2.domain.repository.NoteRepository
import javax.inject.Inject

class DeleteNoteUseCase
@Inject constructor(
    val noteRepository: NoteRepository) {

    suspend fun deleteNote() = noteRepository.deleteNote()
}