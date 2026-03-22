package org.lafeuille.demo.infra.redis

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.data.redis.test.autoconfigure.DataRedisTest
import org.springframework.context.annotation.Import
import org.springframework.data.redis.core.ReactiveRedisTemplate
import reactor.test.StepVerifier

@Import(RedisContainerTestConfiguration::class)
@DataRedisTest
class InfraRedisTest (
    @Autowired val redisTemplate: ReactiveRedisTemplate<String, String>
){

    @Test
    fun testReactiveOperations() {
        val setOperation = redisTemplate.opsForValue().set("message", "Hello Reactive Redis")
        val getOperation = redisTemplate.opsForValue().get("message")

        setOperation.then(getOperation)
            .`as`(StepVerifier::create)
            .expectNext("Hello Reactive Redis")
            .verifyComplete()
    }
}