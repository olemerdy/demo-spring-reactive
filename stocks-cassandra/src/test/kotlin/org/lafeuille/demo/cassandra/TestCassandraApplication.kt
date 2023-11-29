package org.lafeuille.demo.cassandra

import org.lafeuille.demo.Application
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(CassandraContainerTestConfiguration::class).run(*args)
}