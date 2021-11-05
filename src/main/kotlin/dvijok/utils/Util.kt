package dvijok.utils

import com.fasterxml.jackson.module.kotlin.MissingKotlinParameterException
import dvijok.model.User
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.request.*
import kotlin.reflect.KType
import kotlin.reflect.typeOf

object Util {
    inline fun<T> T?.guard(nullClause: () -> Nothing): T {
        return this ?: nullClause()
    }
    @OptIn(ExperimentalStdlibApi::class)
    suspend inline fun <reified T : Any> ApplicationCall.receiveOrMiss(): T? = receiveOrMiss(typeOf<T>())

    suspend fun <T : Any> ApplicationCall.receiveOrMiss(type: KType): T? {
        return try {
            receive<T>(type)
        } catch (cause: MissingKotlinParameterException) {
            application.log.debug("Conversion failed, null returned", cause)
            null
        }
    }

    val ApplicationCall.user get() = authentication.principal<User>()

}


