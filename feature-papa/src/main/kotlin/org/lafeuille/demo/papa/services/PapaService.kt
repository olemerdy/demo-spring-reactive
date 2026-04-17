package org.lafeuille.demo.papa.services

import org.lafeuille.demo.papa.data.Papa
import org.lafeuille.demo.papa.data.PapaRepository
import org.lafeuille.demo.papa.domain.PapaResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Mono
import reactor.kotlin.core.publisher.cast
import java.util.UUID

@Service
class PapaService(
    private val repository: PapaRepository,
) {
    fun getPapas(pageable: Pageable): Mono<Page<PapaResponse>> =
        Mono.zip(
            repository.count(),
            repository.findBy(pageable).collectList(),
        ) { count: Long, list: List<Papa> ->
            PageImpl(list, pageable, count)
                .map { it.toResponse() }
        }

    fun getPapa(id: UUID): Mono<PapaResponse> =
        repository
            .findById(id)
            .map { it.toResponse() }

    @Transactional
    fun deletePapa(id: UUID): Mono<Unit> = repository.deleteById(id).cast()
}
