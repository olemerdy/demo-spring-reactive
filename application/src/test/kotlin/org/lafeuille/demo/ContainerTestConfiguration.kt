package org.lafeuille.demo

import org.lafeuille.demo.infra.RabbitMQDefaults
import org.lafeuille.demo.infra.cassandra.CassandraDefaults
import org.lafeuille.demo.infra.elasticsearch.ElasticsearchDefaults
import org.lafeuille.demo.infra.mongo.MongoDefaults
import org.lafeuille.demo.infra.neo4j.Neo4jDefaults
import org.lafeuille.demo.infra.r2dbc.PostgresDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.*
import org.testcontainers.elasticsearch.ElasticsearchContainer

@TestConfiguration(proxyBeanMethods = false)
class ContainerTestConfiguration {

    @Bean
    @ServiceConnection
    fun cassandra() = CassandraContainer(CassandraDefaults.DOCKER_IMAGE_NAME)

    @Bean
    @ServiceConnection
    fun elasticsearch() = ElasticsearchContainer(ElasticsearchDefaults.DOCKER_IMAGE_NAME)

    @Bean
    @ServiceConnection
    fun mongoDb() = MongoDBContainer(MongoDefaults.DOCKER_IMAGE_NAME)

    @Bean
    @ServiceConnection
    fun neo4j() = Neo4jContainer(Neo4jDefaults.DOCKER_IMAGE_NAME)

    @Bean
    @ServiceConnection
    fun postgres() = PostgreSQLContainer(PostgresDefaults.DOCKER_IMAGE_NAME)

    @Bean
    @ServiceConnection
    fun rabbitMq() = RabbitMQContainer(RabbitMQDefaults.DOCKER_IMAGE_NAME)
}