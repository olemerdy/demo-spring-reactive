package org.lafeuille.demo.infra.neo4j

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import java.time.Instant
import java.util.UUID

@Node
data class SampleData(
    @Id val id: UUID,
    val value: Double,
    val timestamp: Instant,
)
