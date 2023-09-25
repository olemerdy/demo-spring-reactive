package org.lafeuille.demo.mongo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestMongoApplication

fun main(args: Array<String>) {
    runApplication<TestMongoApplication>(*args)
}