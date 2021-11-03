package dvijok.plugins

import dvijok.model.DefaultResponse
import dvijok.model.User
import dvijok.service.authorization.AuthorizeService
import dvijok.utils.Util.guard
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.http.*
import io.ktor.request.*
import io.ktor.response.*
import io.ktor.routing.*
import org.koin.core.component.getScopeId


fun Application.configureAuthorize(service: AuthorizeService){
    routing {
        post("/regisrter"){
            val response = call.receive<User>()
            call.respond(service.newUser(response))
        }
        post("/auth"){
            val response = call.receive<User>()
//            call.respond(service.authorizeUser(response))
        }
    }
}