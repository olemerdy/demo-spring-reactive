package org.lafeuille.demo.infra.cassandra

import org.springframework.data.cassandra.core.mapping.PrimaryKey
import org.springframework.data.cassandra.core.mapping.Table
import java.time.Instant
import java.util.UUID

@Table
data class SampleData(
    @PrimaryKey val id: UUID = UUID.randomUUID(),
    val value: Double,
    val timestamp: Instant,
)
