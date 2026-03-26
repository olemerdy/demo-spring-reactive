package org.lafeuille.demo.infra.r2dbc

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table("samples")
data class SampleData(
    @Id val id: UUID,
    val value: Double,
    val timestamp: Instant,
)
