package org.lafeuille.demo.stores.services

import org.lafeuille.demo.stores.data.Store
import org.lafeuille.demo.stores.domain.StoreResponse

internal fun Store.toResponse() =
    StoreResponse(
        id = this.id,
    )
