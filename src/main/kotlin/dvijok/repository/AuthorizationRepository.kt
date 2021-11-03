package dvijok.repository

import dvijok.model.DefaultResponse
import dvijok.model.User
import dvijok.model.UserTable
import dvijok.model.UserTableDao
import dvijok.utils.Hashing.sha256
import dvijok.utils.Util.guard
import io.ktor.http.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
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


    fun authorizeUser(user: User): DefaultResponse {
        var response = DefaultResponse("", HttpStatusCode.GatewayTimeout)
        try {
            transaction {
                val userDB = UserTableDao.find{UserTable.login eq user.login}.firstOrNull().guard{
                    DefaultResponse("Пользователь не найден", HttpStatusCode.BadRequest)
                    return@transaction
                }
                response = if (userDB.secret == user.password.sha256()) {
                    DefaultResponse("Успешно", HttpStatusCode.OK)
                } else{
                    DefaultResponse("Неверный пароль", HttpStatusCode.BadRequest)
                }


            }
        }
        catch (e:Exception){
            response = DefaultResponse(e.localizedMessage,HttpStatusCode.InternalServerError)
        }
        return response
    }
}