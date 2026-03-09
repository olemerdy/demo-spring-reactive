package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.elasticsearch.ElasticsearchContainerTestConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(ElasticsearchContainerTestConfiguration::class)
@SpringBootTest
class FeatureEchoTest {
    @Test
    fun contextLoads() {
    }
}