package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.RabbitMQContainerTestConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(RabbitMQContainerTestConfiguration::class)
@SpringBootTest
class FeatureQuebecTest {
    @Test
    fun contextLoads() {
    }
}