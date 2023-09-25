package org.lafeuille.demo.neo4j.infra

import org.lafeuille.demo.infra.data.InfraDataConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.data.neo4j.config.EnableNeo4jAuditing

@Configuration
@EnableNeo4jAuditing(dateTimeProviderRef = InfraDataConfiguration.BeanNames.DATE_TIME_PROVIDER_NAME)
class InfraDataNeo4jConfiguration