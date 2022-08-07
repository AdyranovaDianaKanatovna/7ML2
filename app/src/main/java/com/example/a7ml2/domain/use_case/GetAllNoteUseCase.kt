package com.example.a7ml2.domain.use_case

import com.example.a7ml2.domain.repository.NoteRepository
import javax.inject.Inject

class GetAllNotesUseCase @Inject constructor(
    private val noteRepository: NoteRepository
) {

    suspend fun getAllNotes() = noteRepository.getAllNote()

}