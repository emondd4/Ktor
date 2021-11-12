package com.example

import com.example.entities.NotesEntity
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import org.ktorm.database.Database
import org.ktorm.dsl.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "192.168.0.109") {
        install(ContentNegotiation){
            json()
        }
        responseRouting()
        configureRouting()
        contactUsRouting()
        urlParameterRouting()

        val database = Database.connect(
            url = "jdbc:mysql://localhost:3306/notes",
            driver = "com.mysql.cj.jdbc.Driver",
            user = "root",
            password = ""
        )

//        database.insert(NotesEntity){
//            set(it.title,"third")
//            set(it.description,"this is third")
//        }

//        val preNotes = database.from(NotesEntity).select()
//
//        for (i in preNotes){
//            println("${i[NotesEntity.id]} : ${i[NotesEntity.title]} : ${i[NotesEntity.description]}")
//        }
//
//        database.update(NotesEntity) {
//            set(it.title,"1st")
//            where {
//                it.id eq 2
//            }
//        }
//
//
//        database.delete(NotesEntity){
//            it.id eq 4
//        }


    }.start(wait = true)
}