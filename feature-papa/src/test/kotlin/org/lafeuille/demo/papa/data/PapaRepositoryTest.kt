package org.lafeuille.demo.papa.data

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.postgresql.PostgresqlContainerTestConfiguration
import org.lafeuille.demo.papa.domain.PapaFixtures
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.r2dbc.test.autoconfigure.DataR2dbcTest
import org.springframework.context.annotation.Import
import org.springframework.data.domain.Pageable
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate
import reactor.kotlin.test.test

@DataR2dbcTest
@Import(PostgresqlContainerTestConfiguration::class)
class PapaRepositoryTest(
    @Autowired private val template: R2dbcEntityTemplate,
    @Autowired private val repository: PapaRepository,
) {
    @Test
    fun find_papa_page() {
        repository
            .findBy(Pageable.ofSize(10))
            .test()
            .assertNext { (id, name, birthDate): Papa ->
                assertThat(id).isEqualTo(PapaFixtures.ID)
                assertThat(name).isEqualTo(PapaFixtures.NAME)
                assertThat(birthDate).isEqualTo(PapaFixtures.BIRTH_DATE)
            }.assertNext { (id, name, birthDate): Papa ->
                assertThat(id).isEqualTo(PapaFixtures.OTHER_ID)
                assertThat(name).isEqualTo(PapaFixtures.OTHER_NAME)
                assertThat(birthDate).isEqualTo(PapaFixtures.OTHER_BIRTH_DATE)
            }.verifyComplete()
    }

    @Test
    fun find_papa_by_id() {
        repository
            .findById(PapaFixtures.ID)
            .test()
            .assertNext { (id, name, birthDate): Papa ->
                assertThat(id).isEqualTo(PapaFixtures.ID)
                assertThat(name).isEqualTo(PapaFixtures.NAME)
                assertThat(birthDate).isEqualTo(PapaFixtures.BIRTH_DATE)
            }.verifyComplete()
    }
}
