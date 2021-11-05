package dvijok.model

import dvijok.model.UserToken
import io.ktor.http.*

data class AuthorizationResponse(
    val error: String? = null,
    val statusCode: HttpStatusCode = HttpStatusCode.OK,
    val data: UserToken? = null,
)
