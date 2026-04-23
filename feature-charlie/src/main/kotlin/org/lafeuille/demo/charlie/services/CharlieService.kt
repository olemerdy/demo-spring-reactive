package org.lafeuille.demo.charlie.services

import org.lafeuille.demo.charlie.data.Charlie
import org.lafeuille.demo.charlie.data.CharlieRepository
import org.lafeuille.demo.charlie.domain.CharlieResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.UUID

@Service
class CharlieService(
    private val repository: CharlieRepository,
) {
    fun getCharlies(pageable: Pageable): Mono<Page<CharlieResponse>> =
        Mono.zip(
            repository.count(),
            repository.findBy(pageable).collectList(),
        ) { count: Long, list: List<Charlie> ->
            PageImpl(list, pageable, count)
                .map { it.toResponse() }
        }

    fun getCharlie(id: UUID): Mono<CharlieResponse> =
        repository
            .findById(id)
            .map { it.toResponse() }

    fun deleteCharlie(id: UUID): Mono<Void> = repository.deleteById(id)
}
