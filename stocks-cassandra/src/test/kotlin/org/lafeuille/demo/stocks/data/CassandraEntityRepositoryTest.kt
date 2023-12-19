package org.lafeuille.demo.stocks.data

import org.junit.jupiter.api.Test
import org.lafeuille.demo.infra.cassandra.CassandraContainerTestConfiguration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.data.cassandra.DataCassandraTest
import org.springframework.context.annotation.Import
import reactor.kotlin.test.test

@DataCassandraTest(properties = ["spring.data.cassandra.keyspace-name=test"])
@Import(CassandraContainerTestConfiguration::class)
class CassandraEntityRepositoryTest(
    @Autowired private val repository: CassandraEntityRepository
) {

    @Test
    fun test() {
        repository.findAll().test().verifyComplete()
    }
}