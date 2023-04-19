package br.com.alura.responses

import kotlinx.serialization.Serializable

@Serializable
class NoteResponse(
    val id: String,
    val title: String,
    val message: String
)