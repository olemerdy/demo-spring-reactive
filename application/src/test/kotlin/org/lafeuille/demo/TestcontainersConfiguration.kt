package org.lafeuille.demo

import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.testcontainers.service.connection.ServiceConnection
import org.springframework.context.annotation.Bean
import org.testcontainers.cassandra.CassandraContainer
import org.testcontainers.containers.GenericContainer
import org.testcontainers.elasticsearch.ElasticsearchContainer
import org.testcontainers.mongodb.MongoDBContainer
import org.testcontainers.neo4j.Neo4jContainer
import org.testcontainers.rabbitmq.RabbitMQContainer
import org.testcontainers.utility.DockerImageName

@TestConfiguration(proxyBeanMethods = false)
class TestcontainersConfiguration {

    @Bean
    @ServiceConnection
    fun cassandraContainer(): CassandraContainer {
        return CassandraContainer(DockerImageName.parse("cassandra:latest"))
    }

    @Bean
    @ServiceConnection
    fun elasticsearchContainer(): ElasticsearchContainer {
        return ElasticsearchContainer(DockerImageName.parse("docker.elastic.co/elasticsearch/elasticsearch:7.17.10"))
    }

    @Bean
    @ServiceConnection
    fun mongoDbContainer(): MongoDBContainer {
        return MongoDBContainer(DockerImageName.parse("mongo:latest"))
    }

    @Bean
    @ServiceConnection
    fun neo4jContainer(): Neo4jContainer {
        return Neo4jContainer(DockerImageName.parse("neo4j:latest"))
    }

    @Bean
    @ServiceConnection
    fun rabbitContainer(): RabbitMQContainer {
        return RabbitMQContainer(DockerImageName.parse("rabbitmq:latest"))
    }

    @Bean
    @ServiceConnection(name = "redis")
    fun redisContainer(): GenericContainer<*> {
        return GenericContainer(DockerImageName.parse("redis:latest")).withExposedPorts(6379)
    }

}
