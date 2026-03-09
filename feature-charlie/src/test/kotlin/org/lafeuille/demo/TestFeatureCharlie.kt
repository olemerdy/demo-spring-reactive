package org.lafeuille.demo

import org.lafeuille.demo.infra.couchbase.CouchbaseContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(CouchbaseContainerTestConfiguration::class).run(*args)
}