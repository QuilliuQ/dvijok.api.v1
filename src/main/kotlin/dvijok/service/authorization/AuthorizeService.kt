package dvijok.service.authorization

import dvijok.model.DefaultResponse
import dvijok.model.User
import dvijok.model.AuthorizationResponse
import io.ktor.auth.*

interface AuthorizeService {
    fun newUser(user: User): DefaultResponse
    fun authorizeUser(user:UserPasswordCredential): AuthorizationResponse
//    fun updateUser(user: User):DefaultResponse
}