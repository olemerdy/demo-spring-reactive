package org.lafeuille.demo.infra.neo4j

import org.neo4j.driver.Driver
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.core.ReactiveDatabaseSelectionProvider
import org.springframework.data.neo4j.core.transaction.ReactiveNeo4jTransactionManager
import org.springframework.data.neo4j.repository.config.ReactiveNeo4jRepositoryConfigurationExtension

@Configuration
class InfraDataReactiveNeo4jConfiguration {
    @Bean(name = [ReactiveNeo4jRepositoryConfigurationExtension.DEFAULT_TRANSACTION_MANAGER_BEAN_NAME])
    fun reactiveTransactionManager(
        driver: Driver,
        databaseSelectionProvider: ReactiveDatabaseSelectionProvider
    ) = ReactiveNeo4jTransactionManager(driver, databaseSelectionProvider)
}