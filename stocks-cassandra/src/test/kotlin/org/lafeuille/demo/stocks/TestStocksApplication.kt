package org.lafeuille.demo.stocks

import org.lafeuille.demo.Application
import org.lafeuille.demo.infra.cassandra.CassandraContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(CassandraContainerTestConfiguration::class).run(*args)
}