package dvijok

import dvijok.di.authorizationAppModule
import io.ktor.server.engine.*
import io.ktor.server.tomcat.*
import dvijok.plugins.*
import dvijok.service.authorization.AuthorizeService
import io.ktor.application.*
import io.ktor.features.*
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
    }.start(wait = true)
}
