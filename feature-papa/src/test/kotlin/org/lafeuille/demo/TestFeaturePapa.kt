package org.lafeuille.demo

import org.lafeuille.demo.infra.postgresql.PostgresqlContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(PostgresqlContainerTestConfiguration::class).run(*args)
}
