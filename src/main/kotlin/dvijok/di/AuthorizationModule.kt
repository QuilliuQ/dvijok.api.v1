package dvijok.di

import dvijok.repository.AuthorizationRepository
import dvijok.service.authorization.AuthorizationServiceImpl
import dvijok.service.authorization.AuthorizeService
import org.koin.dsl.bind
import org.koin.dsl.module
import org.koin.dsl.single

val authorizationAppModule = module(createdAtStart = true) {
    single<AuthorizationRepository>()
    single<AuthorizationServiceImpl>() bind AuthorizeService::class
}