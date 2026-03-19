package org.lafeuille.demo

import org.lafeuille.demo.infra.cassandra.CassandraContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(CassandraContainerTestConfiguration::class).run(*args)
}
