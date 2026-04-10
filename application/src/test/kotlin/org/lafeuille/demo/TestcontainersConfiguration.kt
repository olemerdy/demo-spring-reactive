package org.lafeuille.demo

import org.lafeuille.demo.infra.cassandra.CassandraContainerTestConfiguration
import org.lafeuille.demo.infra.couchbase.CouchbaseContainerTestConfiguration
import org.lafeuille.demo.infra.elasticsearch.ElasticsearchContainerTestConfiguration
import org.lafeuille.demo.infra.mongo.MongoContainerTestConfiguration
import org.lafeuille.demo.infra.neo4j.Neo4jContainerTestConfiguration
import org.lafeuille.demo.infra.postgresql.PostgresqlContainerTestConfiguration
import org.lafeuille.demo.infra.redis.RedisContainerTestConfiguration
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Import

@Import(
    value = [
        CassandraContainerTestConfiguration::class,
        CouchbaseContainerTestConfiguration::class,
        ElasticsearchContainerTestConfiguration::class,
        MongoContainerTestConfiguration::class,
        Neo4jContainerTestConfiguration::class,
        PostgresqlContainerTestConfiguration::class,
        RedisContainerTestConfiguration::class,
    ],
)
@TestConfiguration
class TestcontainersConfiguration
