package com.example.plugins

import com.example.db.DatabaseConnection
import com.example.entities.NotesEntity
import com.example.model.NotesModel
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import org.ktorm.dsl.from
import org.ktorm.dsl.map
import org.ktorm.dsl.select

fun Application.notesRoutes(){

    val db = DatabaseConnection.database

    routing {
        get("/notes"){
            val notes = db.from(NotesEntity).select()
                .map {
                    val id = it[NotesEntity.id]
                    val title = it[NotesEntity.title]
                    val description = it[NotesEntity.description]
                    NotesModel(id,title,description)
                }
            call.respond(notes)
        }
    }

}