package org.lafeuille.demo.stores.data

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import java.util.*

interface StoreRepository : ReactiveMongoRepository<Store, UUID>