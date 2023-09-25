package org.lafeuille.demo.mongo

import org.lafeuille.demo.Application
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.fromApplication
import org.springframework.boot.runApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration
class TestMongoApplication

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestMongoApplication::class).run(*args)
}