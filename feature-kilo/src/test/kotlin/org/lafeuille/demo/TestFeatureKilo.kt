package org.lafeuille.demo

import org.lafeuille.demo.infra.kafka.KafkaContainerTestConfiguration
import org.springframework.boot.fromApplication
import org.springframework.boot.with

fun main(args: Array<String>) {
    fromApplication<Application>().with(KafkaContainerTestConfiguration::class).run(*args)
}