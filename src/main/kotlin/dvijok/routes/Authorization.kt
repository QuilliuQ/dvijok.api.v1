package dvijok.routes

import dvijok.model.DefaultResponse
import dvijok.model.User
import dvijok.service.authorization.AuthorizeService
import dvijok.utils.Util.guard
import dvijok.utils.Util.receiveOrMiss
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*


fun Application.configureAuthorize(service: AuthorizeService){
    routing {
        post("/register"){
            val response = call.receiveOrMiss<User>().guard {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            call.respond(service.newUser(response))
        }
        post("/auth"){

            val response = call.receiveOrMiss<UserPasswordCredential>().guard {
                call.respond(HttpStatusCode.BadRequest)
                return@post
            }
            val auth = service.authorizeUser(response)
            if (auth.statusCode.isSuccess()&& auth.data != null){
                call.respond(auth.data)
            }
            else
            {
                call.respond(auth.statusCode,message = auth.error!!)
            }

        }
    }
}

