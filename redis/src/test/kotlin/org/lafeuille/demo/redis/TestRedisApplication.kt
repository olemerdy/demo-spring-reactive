package org.lafeuille.demo.redis

import org.lafeuille.demo.Application
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(RedisContainerTestConfiguration::class).run(*args)
}