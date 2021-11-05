package com.example

import io.ktor.server.engine.*
import io.ktor.server.netty.*
import com.example.plugins.*

fun main() {
    embeddedServer(Netty, port = 8080, host = "192.168.0.109") {
        configureRouting()
        contactUsRouting()
        urlParameterRouting()
    }.start(wait = true)
}
