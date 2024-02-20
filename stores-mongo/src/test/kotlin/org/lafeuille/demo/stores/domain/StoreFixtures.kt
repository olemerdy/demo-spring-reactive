package org.lafeuille.demo.stores.domain

import org.springframework.data.geo.Point
import java.util.UUID

object StoreFixtures {
    const val ID_STRING = "ed41a7d0-1f7e-4f92-a91f-b6fe99384f3f"
    val ID: UUID by lazy { UUID.fromString(ID_STRING) }

    const val NAME = "Bookstore"

    val LOCATION: Point by lazy { Point(0.0, 0.0) }

    fun defaultStoreResponse() = StoreResponse(id = ID, name = NAME, location = LOCATION)
}