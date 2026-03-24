package org.lafeuille.demo.infra.mongo

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant
import java.util.UUID

@Document(collection = "samples")
data class SampleData(
    @Id val id: UUID,
    val value: Double,
    val timestamp: Instant,
)
