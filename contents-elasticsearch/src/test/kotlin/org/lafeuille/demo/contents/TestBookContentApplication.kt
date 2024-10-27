package org.lafeuille.demo.contents

import org.lafeuille.demo.Application
import org.lafeuille.demo.infra.elasticsearch.ElasticsearchContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(ElasticsearchContainerTestConfiguration::class).run(*args)
}
