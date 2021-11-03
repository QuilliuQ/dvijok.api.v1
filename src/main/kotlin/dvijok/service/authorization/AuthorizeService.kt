package dvijok.service.authorization

import dvijok.model.DefaultResponse
import dvijok.model.User

interface AuthorizeService {
    fun newUser(user: User): DefaultResponse
    fun authorizeUser(user:User):DefaultResponse
//    fun updateUser(user: User):DefaultResponse
}