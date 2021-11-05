package dvijok

import dvijok.di.authorizationAppModule
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*
import dvijok.plugins.*
import dvijok.routes.configureAuthorize
import dvijok.service.authorization.AuthorizeService
import dvijok.utils.JWTConfig
import io.ktor.application.*
import io.ktor.auth.*
import io.ktor.auth.jwt.*
import io.ktor.features.*
import io.ktor.routing.*
import org.koin.ktor.ext.Koin
import org.koin.ktor.ext.inject
import org.koin.logger.SLF4JLogger
import org.slf4j.event.Level

fun main() {
    embeddedServer(Tomcat, port = 8080, host = "0.0.0.0") {
        install(CallLogging){ level = Level.INFO}
        install(Koin) {
            SLF4JLogger()
            modules(authorizationAppModule)
        }
        val service: AuthorizeService by inject()
        configureRouting(service)
        configureSerialization()
        configureAuthorize(service)
        confugireStatusPages()
        configureStaticRouting()
        configureDatabase()
        install(Authentication) {
            
            jwt {
                verifier(JWTConfig.verifier)
                realm = "ktor.io"
//                validate {
//                    it.payload.getClaim("id").asInt()?.let{userSource::findUserById}
//                }
            }
        }
    }.start(wait = true)
}
