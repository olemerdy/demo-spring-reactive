package org.lafeuille.demo

import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(ContainerTestConfiguration::class).run(*args)
}
