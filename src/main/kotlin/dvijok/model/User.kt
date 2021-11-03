package dvijok.model


import org.jetbrains.exposed.dao.*
import java.util.*

data class User(
    val id : UUID? = null,
    val login: String,
    val password: String,
    val firstName: String? = null,
    val avatar: String? = null
)


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


data class UserToken(val userId: Int,val token: Int)
object Token : IntIdTable("token"){
    val token = integer("token")
}
class TokenDao(id:EntityID<Int>):IntEntity(id){

}