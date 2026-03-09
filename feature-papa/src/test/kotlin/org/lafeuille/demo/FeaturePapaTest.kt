package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.postgresql.PostgresqlContainerTestConfiguration
import org.springframework.context.annotation.Import

@Import(PostgresqlContainerTestConfiguration::class)
class FeaturePapaTest {
    @Test
    fun contextLoads() {
    }
}