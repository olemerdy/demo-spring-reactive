package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.kafka.KafkaContainerTestConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(KafkaContainerTestConfiguration::class)
@SpringBootTest
class FeatureKiloTest {
    @Test
    fun contextLoads() {
    }
}
