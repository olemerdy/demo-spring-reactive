package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.cassandra.CassandraContainerTestConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(CassandraContainerTestConfiguration::class)
@SpringBootTest
class FeatureSierraTest {
    @Test
    fun contextLoads() {
    }
}