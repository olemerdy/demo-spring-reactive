package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.mongo.MongoContainerTestConfiguration
import org.springframework.context.annotation.Import

@Import(MongoContainerTestConfiguration::class)
class FeatureMikeTest {
    @Test
    fun contextLoads() {
    }
}
