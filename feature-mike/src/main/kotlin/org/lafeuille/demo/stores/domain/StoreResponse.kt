package org.lafeuille.demo.stores.domain

import org.springframework.data.geo.Point
import java.util.UUID

data class StoreResponse(
    val id: UUID,
    val name: String,
    val location: Point,
)
