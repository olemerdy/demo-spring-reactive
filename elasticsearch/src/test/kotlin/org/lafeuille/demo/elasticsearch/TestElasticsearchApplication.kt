package org.lafeuille.demo.elasticsearch

import org.lafeuille.demo.Application
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(ElasticsearchContainerTestConfiguration::class).run(*args)
}