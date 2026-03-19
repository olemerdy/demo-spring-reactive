package org.lafeuille.demo

import org.lafeuille.demo.infra.redis.RedisContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(RedisContainerTestConfiguration::class).run(*args)
}
