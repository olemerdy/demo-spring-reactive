package org.lafeuille.demo.infra.elasticsearch

import org.lafeuille.demo.infra.data.InfraDataConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.data.elasticsearch.config.EnableReactiveElasticsearchAuditing

@Configuration
@EnableReactiveElasticsearchAuditing(dateTimeProviderRef = InfraDataConfiguration.BeanNames.DATE_TIME_PROVIDER_NAME)
class InfraDataElasticsearchConfiguration
