package org.lafeuille.demo.infra.r2dbc

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.postgresql.PostgresqlContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.r2dbc.test.autoconfigure.DataR2dbcTest
import org.springframework.context.annotation.Import
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import reactor.kotlin.test.test
import java.time.Instant
import java.time.LocalDateTime
import java.time.Month
import java.time.ZoneOffset
import java.util.UUID

@Import(PostgresqlContainerTestConfiguration::class)
@DataR2dbcTest
class InfraR2dbcTest(
    @Autowired val entityTemplate: R2dbcEntityTemplate,
) {
    @Test
    fun testInsert() {
        val data = SampleData(id = UUID.randomUUID(), value = 123.0, timestamp = Instant.EPOCH)
        entityTemplate
            .insert(data)
            .test()
            .expectNext(data)
            .verifyComplete()
    }

    @Test
    fun testLoad() {
        val data =
            SampleData(
                id = UUID.fromString("7d3bb7ac-b5c1-4efd-b672-af52c43a98fb"),
                value = 123.0,
                timestamp =
                    LocalDateTime.of(2026, Month.MARCH, 26, 14, 0).toInstant(ZoneOffset.UTC),
            )
        entityTemplate
            .select(SampleData::class.java)
            .all()
            .test()
            .expectNext(data)
            .verifyComplete()
    }
}
