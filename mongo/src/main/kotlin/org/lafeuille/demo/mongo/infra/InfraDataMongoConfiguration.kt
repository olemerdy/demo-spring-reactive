package org.lafeuille.demo.mongo.infra

import org.lafeuille.demo.infra.data.InfraDataConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.config.EnableReactiveMongoAuditing

@Configuration
@EnableReactiveMongoAuditing(dateTimeProviderRef = InfraDataConfiguration.BeanNames.DATE_TIME_PROVIDER_NAME)
class InfraDataMongoConfiguration