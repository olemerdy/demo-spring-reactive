package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.neo4j.Neo4JContainerTestConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(Neo4JContainerTestConfiguration::class)
@SpringBootTest
class FeatureNovemberTest {
    @Test
    fun contextLoads() {
    }
}
