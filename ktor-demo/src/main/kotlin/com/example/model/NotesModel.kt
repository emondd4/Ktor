package com.example.model

import kotlinx.serialization.Serializable

@Serializable
data class NotesModel(
    val id: Int?,
    val title: String?,
    val description: String?
)
