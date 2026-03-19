package org.lafeuille.demo

import org.lafeuille.demo.infra.neo4j.Neo4JContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(Neo4JContainerTestConfiguration::class).run(*args)
}
