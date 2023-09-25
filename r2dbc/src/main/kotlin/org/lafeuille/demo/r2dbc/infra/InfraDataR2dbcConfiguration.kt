package org.lafeuille.demo.r2dbc.infra

import org.lafeuille.demo.infra.data.InfraDataConfiguration
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.EnableR2dbcAuditing

@Configuration
@EnableR2dbcAuditing(dateTimeProviderRef = InfraDataConfiguration.BeanNames.DATE_TIME_PROVIDER_NAME)
class InfraDataR2dbcConfiguration