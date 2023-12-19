package org.lafeuille.demo.books

import org.lafeuille.demo.Application
import org.lafeuille.demo.infra.neo4j.Neo4jContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(Neo4jContainerTestConfiguration::class).run(*args)
}