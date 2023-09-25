package org.lafeuille.demo.cassandra

import org.lafeuille.demo.Application
import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestCassandraApplication

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestCassandraApplication::class).run(*args)
}