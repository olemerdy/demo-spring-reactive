package org.lafeuille.demo.echo.services

import org.lafeuille.demo.echo.data.Echo
import org.lafeuille.demo.echo.data.EchoRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class EchoService(
    private val repository: EchoRepository,
) {
    fun getEcho(isbn: String): Mono<Echo> = repository.findById(isbn)
}
