package org.lafeuille.demo.infra.data

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.auditing.DateTimeProvider
import java.time.Clock
import java.util.*

@Configuration
class InfraDataConfiguration {

    @Bean(name = [BeanNames.DATE_TIME_PROVIDER_NAME])
    fun dateTimeProvider(clock: Clock): DateTimeProvider {
        return DateTimeProvider { Optional.of(clock.instant()) }
    }

    object BeanNames {
        const val DATE_TIME_PROVIDER_NAME = "dateTimeProvider"
    }
}