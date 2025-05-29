package org.lafeuille.demo.infra

import org.lafeuille.demo.infra.elasticsearch.ElasticsearchDefaults
import org.lafeuille.demo.infra.mongo.MongoDefaults
import org.lafeuille.demo.infra.neo4j.Neo4jDefaults
import org.lafeuille.demo.infra.r2dbc.PostgresDefaults
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.containers.MongoDBContainer
import org.testcontainers.containers.Neo4jContainer
import org.testcontainers.containers.PostgreSQLContainer
import org.testcontainers.containers.RabbitMQContainer
import org.testcontainers.elasticsearch.ElasticsearchContainer
import java.time.Duration

@TestConfiguration(proxyBeanMethods = false)
class ContainerTestConfiguration {
    @Bean
    @ServiceConnection
    fun elasticsearch(): ElasticsearchContainer =
        ElasticsearchContainer(ElasticsearchDefaults.DOCKER_IMAGE_NAME)
            .withEnv("xpack.security.enabled", "" + false)

    @Bean
    @ServiceConnection
    fun mongoDb() = MongoDBContainer(MongoDefaults.DOCKER_IMAGE_NAME)

    @Bean
    @ServiceConnection
    fun neo4j() = Neo4jContainer(Neo4jDefaults.DOCKER_IMAGE_NAME)

    @Bean
    @ServiceConnection
    fun postgres(): PostgreSQLContainer<*> =
        PostgreSQLContainer(PostgresDefaults.DOCKER_IMAGE_NAME)
            .withMinimumRunningDuration(Duration.ofSeconds(3))

    @Bean
    @ServiceConnection
    fun rabbitMq() = RabbitMQContainer(RabbitMQDefaults.DOCKER_IMAGE_NAME)
}
