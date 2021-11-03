package dvijok.plugins


import io.ktor.application.*
import org.jetbrains.exposed.sql.Database

fun Application.configureDatabase(){
    Database.connect(
        driver = "org.postgresql.Driver",
        user = "postgres",
        password = "Repmvbyffyz",
        url = "jdbc:postgresql://localhost:5432/main"
    )
}

//url = "jdbc:mysql://srv/vos2021?allowPublicKeyRetrieval=true&useSSL=false&useUnicode=true&serverTimezone=UTC"