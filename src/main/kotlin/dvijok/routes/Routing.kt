package dvijok.plugins

import dvijok.model.MenuDao
import dvijok.model.MenuItem
import dvijok.service.authorization.AuthorizeService
import io.ktor.routing.*
import io.ktor.application.*
import io.ktor.response.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureRouting(service: AuthorizeService) {
    routing {
        get( "/menu"){
            var list = listOf<MenuItem>()
            transaction {
                list = MenuDao.all().map {item->
                    item.toMenuItem() }
            }
            call.respond(list)
        }


    }
}