package dvijok.service.authorization

import dvijok.model.DefaultResponse
import dvijok.model.User
import dvijok.service.repository.AuthorizationRepository
import dvijok.model.AuthorizationResponse
import io.ktor.auth.*

class AuthorizationServiceImpl  (private val repository:AuthorizationRepository): AuthorizeService {
    override fun newUser(user: User): DefaultResponse {
        return repository.newUser(user)
    }

    override fun authorizeUser(user: UserPasswordCredential): AuthorizationResponse {
        return repository.authorizeUser(user)
    }


}