package dvijok.plugins

import io.ktor.application.*
import io.ktor.features.*
import io.ktor.http.*
import io.ktor.response.*

fun Application.confugireStatusPages() {
    install(StatusPages) {
        status(HttpStatusCode.NotFound){
            call.respond(HttpStatusCode.NotFound,"Несуществующий запрос")
        }
        status(HttpStatusCode.BadRequest){
            call.respond(HttpStatusCode.BadRequest,"Проверьте корректность запроса")
        }

    }
}