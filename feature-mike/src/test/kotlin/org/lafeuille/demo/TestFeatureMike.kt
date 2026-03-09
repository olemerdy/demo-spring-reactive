package org.lafeuille.demo

import org.lafeuille.demo.infra.mongo.MongoContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(MongoContainerTestConfiguration::class).run(*args)
}
