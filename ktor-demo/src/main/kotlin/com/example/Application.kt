package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*
import org.ktorm.database.Database


fun main() {
    embeddedServer(Netty, port = 8080, host = "192.168.1.195") {
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
            password = "533156"
        )

    }.start(wait = true)
}