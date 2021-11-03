package dvijok.plugins

import io.ktor.application.*
import io.ktor.http.content.*
import io.ktor.response.*
import io.ktor.routing.*

fun Application.configureStaticRouting() {
    routing {
        static("/api/images") {
            resources("files")
        }
    }
}