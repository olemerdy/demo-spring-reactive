package org.lafeuille.demo.infra.r2dbc

import org.junit.jupiter.api.Test
import org.lafeuille.demo.data.SampleDataFixtures
import org.lafeuille.demo.infra.postgresql.PostgresqlContainerTestConfiguration
import org.lafeuille.demo.infra.r2dbc.SampleData.ColumnNames
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.r2dbc.test.autoconfigure.DataR2dbcTest
import org.springframework.context.annotation.Import
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import org.springframework.data.r2dbc.core.select
import org.springframework.data.relational.core.query.Criteria.where
import org.springframework.data.relational.core.query.Query.query
import reactor.kotlin.test.test
import java.time.Instant

@Import(PostgresqlContainerTestConfiguration::class)
@DataR2dbcTest
class InfraR2dbcTest(
    @Autowired val entityTemplate: R2dbcEntityTemplate,
) {
    @Test
    fun testInsert() {
        val data = SampleData(value = SampleDataFixtures.VALUE, timestamp = Instant.EPOCH)
        entityTemplate
            .insert(data)
            .then(
                entityTemplate
                    .select<SampleData>()
                    .matching(query(where(ColumnNames.ID).`is`(data.id)))
                    .one(),
            ).test()
            .expectNext(data)
            .verifyComplete()
    }

    @Test
    fun testLoad() {
        val data = SampleData(id = SampleDataFixtures.ID, value = SampleDataFixtures.VALUE, timestamp = SampleDataFixtures.INSTANT)
        entityTemplate
            .select<SampleData>()
            .all()
            .test()
            .expectNext(data)
            .verifyComplete()
    }
}
