package com.example.plugins

import com.example.model.UserInfo
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.responseRouting(){
    routing {
        get("/status"){
            val responseObject = UserInfo("emondd4@gmail.com","12345678")
            call.respond(responseObject)
            //call.respondText("Successful",status = HttpStatusCode.OK)
        }

        get("/headers"){
            call.response.headers.append("server-name","EmonServer")
            call.response.headers.append("location","Bdtask PC")

            call.respondText("Working Fine")
        }
    }
}