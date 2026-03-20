package org.lafeuille.demo

import org.lafeuille.demo.infra.mongo.MongoContainerTestConfiguration
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Import

@Import(MongoContainerTestConfiguration::class)
@TestConfiguration
class TestcontainersConfiguration
