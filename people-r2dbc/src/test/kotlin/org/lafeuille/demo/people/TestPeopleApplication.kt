package org.lafeuille.demo.people

import org.lafeuille.demo.Application
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(PeopleContainerTestConfiguration::class).run(*args)
}