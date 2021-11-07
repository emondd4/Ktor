package com.example.plugins

import com.example.model.UserInfo
import io.ktor.application.*
import io.ktor.http.HttpHeaders.ContentDisposition
import io.ktor.response.*
import io.ktor.routing.*
import java.io.File
import java.net.http.HttpHeaders

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

        get("/fileDownload") {
            val file = File("files/image1.jpg")

            call.response.header(
                ContentDisposition,
                io.ktor.http.ContentDisposition.Attachment.withParameter(
                    io.ktor.http.ContentDisposition.Parameters.FileName, "downloadableImage.jpg"
                ).toString()
            )

            call.respondFile(file)

        }
        get("/openFile") {
            val file = File("files/image2.jpg")

            call.response.header(
                ContentDisposition,
                io.ktor.http.ContentDisposition.Inline.withParameter(
                    io.ktor.http.ContentDisposition.Parameters.FileName, "openFile.jpg"
                ).toString()
            )

            call.respondFile(file)

        }

    }
}