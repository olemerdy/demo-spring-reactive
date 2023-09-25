package org.lafeuille.demo.redis

import org.lafeuille.demo.Application
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.fromApplication
import org.springframework.boot.runApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with

@TestConfiguration(proxyBeanMethods = false)
class TestRedisApplication

fun main(args: Array<String>) {
    fromApplication<Application>().with(TestRedisApplication::class).run(*args)
}