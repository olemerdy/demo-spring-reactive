package org.lafeuille.demo.neo4j

import org.lafeuille.demo.Application
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(Neo4jContainerTestConfiguration::class).run(*args)
}