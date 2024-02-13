package org.lafeuille.demo.infra.neo4j

import org.lafeuille.demo.infra.data.InfraDataConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.config.EnableReactiveNeo4jAuditing

@Configuration
@EnableReactiveNeo4jAuditing(dateTimeProviderRef = InfraDataConfiguration.BeanNames.DATE_TIME_PROVIDER_NAME)
class InfraDataNeo4jConfiguration
