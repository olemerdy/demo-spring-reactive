package org.lafeuille.demo

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.couchbase.CouchbaseContainerTestConfiguration
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.annotation.Import

@Import(CouchbaseContainerTestConfiguration::class)
@SpringBootTest
class FeatureCharlieTest {
    @Test
    fun contextLoads() {
    }
}