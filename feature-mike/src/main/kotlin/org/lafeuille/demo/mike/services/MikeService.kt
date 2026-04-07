package org.lafeuille.demo.mike.services

import org.lafeuille.demo.mike.data.Mike
import org.lafeuille.demo.mike.data.MikeRepository
import org.lafeuille.demo.mike.domain.MikeResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import reactor.core.publisher.Mono
import java.util.UUID

@Service
class MikeService(
    private val repository: MikeRepository,
) {
    fun getMikes(pageable: Pageable): Mono<Page<MikeResponse>> =
        Mono.zip(
            repository.count(),
            repository.findBy(pageable).collectList(),
        ) { count: Long, list: List<Mike> ->
            PageImpl(list, pageable, count)
                .map { it.toResponse() }
        }

    fun getMike(id: UUID): Mono<MikeResponse> =
        repository
            .findById(id)
            .map { it.toResponse() }

    fun deleteMike(id: UUID): Mono<Void> = repository.deleteById(id)
}
