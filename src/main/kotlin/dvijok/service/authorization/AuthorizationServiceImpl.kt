package dvijok.service.authorization

import dvijok.model.DefaultResponse
import dvijok.model.User
import dvijok.repository.AuthorizationRepository

class AuthorizationServiceImpl  (private val repository:AuthorizationRepository): AuthorizeService {
    override fun newUser(user: User): DefaultResponse {
        return repository.newUser(user)
    }

    override fun authorizeUser(user: User): DefaultResponse {
        return repository.authorizeUser(user)
    }

//    override fun updateUser(user: User): DefaultResponse {
//
//    }

}