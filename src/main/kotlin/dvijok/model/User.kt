package dvijok.model


import io.ktor.auth.*
import org.jetbrains.exposed.dao.*

import java.util.*

data class User(
    val id : UUID? = null,
    val login: String,
    val password: String,
    val firstName: String? = null,
    val avatar: String? = null
): Principal


object UserTable : UUIDTable("users"){
    val login = varchar("login", 128)
    val secret = text("secret")
    val firstName = varchar("firstName",128)
    val avatar = text("avatar")
}


class UserTableDao(id: EntityID<UUID>) : UUIDEntity(id) {
    companion object : UUIDEntityClass<UserTableDao>(UserTable)

    var login by UserTable.login
    var secret by UserTable.secret
    var firstName by UserTable.firstName
    var avatar by UserTable.avatar

}


data class UserToken(val userId: String, val token: String)
object Token : UUIDTable("token"){
    val token = integer("token")
}
class TokenDao(id:EntityID<UUID>):UUIDEntity(id){
    companion object : UUIDEntityClass<TokenDao>(Token)
    var token by Token.token

}