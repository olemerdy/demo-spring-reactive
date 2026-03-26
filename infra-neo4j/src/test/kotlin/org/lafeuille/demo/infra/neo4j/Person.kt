package org.lafeuille.demo.infra.neo4j

import org.springframework.data.neo4j.core.schema.Id
import org.springframework.data.neo4j.core.schema.Node
import org.springframework.data.neo4j.core.schema.Relationship

@Node
data class Person(
    @Id val name: String,
    val born: Int,
    @Relationship(type = "ACTED_IN", direction = Relationship.Direction.OUTGOING)
    val movies: List<Movie> = emptyList(),
)
