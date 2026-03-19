package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.redis.RedisContainerTestConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(RedisContainerTestConfiguration::class)
@SpringBootTest
class FeatureRomeoTest {
    @Test
    fun contextLoads() {
    }
}
