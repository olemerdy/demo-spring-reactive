package org.lafeuille.demo.infra.couchbase

import org.springframework.data.annotation.Id
import org.springframework.data.couchbase.core.mapping.Document
import java.time.Instant
import java.util.UUID

@Document
data class SampleData(
    @Id val id: UUID,
    val value: Double,
    val timestamp: Instant,
)
