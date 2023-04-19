package br.com.alura.models

import br.com.alura.responses.NoteResponse
import java.util.*

class Note(
    val id: UUID = UUID.randomUUID(),
    val title: String,
    val message: String
)

fun Note.toNoteResponse(): NoteResponse {
    return NoteResponse(
        id = id.toString(),
        title = title,
        message = message
    )
}