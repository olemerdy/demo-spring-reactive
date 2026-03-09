package org.lafeuille.demo

import org.lafeuille.demo.infra.mongo.MongoContainerTestConfiguration
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Import
import org.testcontainers.cassandra.CassandraContainer
import org.testcontainers.containers.GenericContainer
import org.testcontainers.elasticsearch.ElasticsearchContainer
import org.testcontainers.mongodb.MongoDBContainer
import org.testcontainers.neo4j.Neo4jContainer
import org.testcontainers.rabbitmq.RabbitMQContainer
import org.testcontainers.utility.DockerImageName

@Import(MongoContainerTestConfiguration::class)
@TestConfiguration
class TestcontainersConfiguration
