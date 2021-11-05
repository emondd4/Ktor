package com.example.plugins

import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.request.*
import io.ktor.response.*

fun Application.configureRouting() {

    routing {

        get("/") {

            println("URI: ${call.request.uri}")
            println("Headers: ${call.request.headers.names()}")
            println("User-Agent: ${call.request.headers["User-Agent"]}")
            println("Accept: ${call.request.headers["Accept"]}")
            println("Host: ${call.request.headers["Host"]}")
            println("Connection: ${call.request.headers["Connection"]}")

            println("Query Params: ${call.request.queryParameters.names()}")
            println("Query Params Name: ${call.request.queryParameters["name"]}")
            println("Query Params Email: ${call.request.queryParameters["email"]}")

            call.respondText("Hello World")
        }
    }
}
