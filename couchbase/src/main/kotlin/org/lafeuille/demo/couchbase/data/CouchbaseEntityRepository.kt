package org.lafeuille.demo.couchbase.data

import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository
import java.util.*

interface CouchbaseEntityRepository : ReactiveCouchbaseRepository<CouchbaseEntity, UUID>