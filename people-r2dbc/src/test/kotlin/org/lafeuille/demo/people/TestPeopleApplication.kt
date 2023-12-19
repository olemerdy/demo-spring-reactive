package org.lafeuille.demo.people

import org.lafeuille.demo.Application
import org.lafeuille.demo.infra.r2dbc.R2dbcContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(R2dbcContainerTestConfiguration::class).run(*args)
}