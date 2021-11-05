package com.example.plugins

import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.contactUsRouting() {

    routing {
        get("/contactus") {
            call.respondText("Contact us")
        }
    }

}