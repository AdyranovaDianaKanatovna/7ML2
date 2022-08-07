package com.example.a7ml2.data.mapper

import com.example.a7ml2.data.model.NoteDto
import com.example.a7ml2.domain.model.Note

class NoteMapper {

    fun toNoteDto(note: Note): NoteDto {
        return NoteDto(
            title = note.title,
            description = note.description)
    }

    fun toNote(noteDto: NoteDto): Note{
        return Note(
            title = noteDto.title,
            description = noteDto.description
        )
    }
}