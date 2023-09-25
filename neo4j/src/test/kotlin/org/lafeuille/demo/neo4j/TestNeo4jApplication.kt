package org.lafeuille.demo.neo4j

import org.lafeuille.demo.Application
import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestNeo4jApplication

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestNeo4jApplication::class).run(*args)
}