package org.lafeuille.demo.infra

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.InjectionPoint
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import java.time.Clock

@Configuration
class InfraConfiguration {

    @Bean
    @ConditionalOnMissingBean(Clock::class)
    fun clock(): Clock {
        return Clock.systemUTC()
    }

    @Bean
    @Scope(BeanDefinition.SCOPE_PROTOTYPE)
    fun logger(injectionPoint: InjectionPoint): Logger {
        return LoggerFactory.getLogger(injectionPoint.member.declaringClass)
    }
}