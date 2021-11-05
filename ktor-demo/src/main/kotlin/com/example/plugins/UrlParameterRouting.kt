package com.example.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.urlParameterRouting() {

    routing {
        get("/page/{number}"){

            val num = call.parameters["number"]

            call.respondText { "You Are On Page Number: $num" }
        }
    }

}