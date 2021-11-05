package dvijok.model

import io.ktor.http.*

data class DefaultResponse(
    var message: String,
    var statusCode: HttpStatusCode
)