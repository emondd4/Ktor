package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*
import io.ktor.application.*
import io.ktor.features.*
import io.ktor.serialization.*


fun main() {
    embeddedServer(Netty, port = 8080, host = "192.168.1.195") {
        install(ContentNegotiation){
            json()
        }
        configureRouting()
        contactUsRouting()
        urlParameterRouting()
    }.start(wait = true)
}