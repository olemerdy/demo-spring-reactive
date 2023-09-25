package org.lafeuille.demo.r2dbc

import org.lafeuille.demo.Application
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.fromApplication
import org.springframework.boot.runApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestR2dbcApplication

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestR2dbcApplication::class).run(*args)
}