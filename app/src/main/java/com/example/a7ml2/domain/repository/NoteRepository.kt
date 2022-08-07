package com.example.a7ml2.domain.repository

import com.example.a7ml2.core.Resource
import com.example.a7ml2.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {

    suspend fun addNote(note: Note): Flow<Resource<Boolean>>
    suspend fun getAllNote(): Flow<Resource<List<Note>>>
    suspend fun deleteNote(): Flow<Resource<Boolean>>
}