package dvijok.service.repository

import dvijok.model.*
import dvijok.model.AuthorizationResponse
import dvijok.utils.Hashing.sha256
import dvijok.utils.JWTConfig
import dvijok.utils.Util.guard
import io.ktor.auth.*
import io.ktor.http.*
import org.jetbrains.exposed.sql.transactions.transaction

class AuthorizationRepository {
    fun newUser(user: User):DefaultResponse {
        var response = DefaultResponse("Сервер Недоступен", HttpStatusCode.GatewayTimeout)
        try{
            transaction {
                UserTableDao.find{ UserTable.login eq user.login}.singleOrNull() ?:
                UserTableDao.new {
                    login = user.login
                    secret = user.password.sha256()
                    firstName = user.firstName!!
                }.also {
                    response = DefaultResponse("Пользователь успешно создан",HttpStatusCode.Created)

                }
                response = DefaultResponse("Имя пользователя занято",HttpStatusCode.BadRequest)
            }
        }
        catch (e:Exception){
            response = DefaultResponse(e.localizedMessage,HttpStatusCode.InternalServerError)
        }
        return response
    }


    fun authorizeUser(user: UserPasswordCredential): AuthorizationResponse {
        var response = AuthorizationResponse("", HttpStatusCode.GatewayTimeout)
        try {
            transaction {
                val userDB = UserTableDao.find{UserTable.login eq user.name}.firstOrNull().guard{
                    AuthorizationResponse("Пользователь не найден", HttpStatusCode.BadRequest)
                    return@transaction
                }
                response = if (userDB.secret == user.password.sha256()) {
                    AuthorizationResponse(data = UserToken(token = JWTConfig.makeToken(userDB.id.value), userId = userDB.id.value.toString()))
                } else{
                    AuthorizationResponse("Неверный пароль", HttpStatusCode.BadRequest)
                }


            }
        }
        catch (e:Exception){
            response = AuthorizationResponse(error = e.localizedMessage,statusCode = HttpStatusCode.InternalServerError)
        }
        return response
    }
}