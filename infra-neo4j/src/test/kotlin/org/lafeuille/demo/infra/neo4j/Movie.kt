package org.lafeuille.demo.infra.neo4j

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node

@Node
data class Movie(
    @Id val title: String,
)
