package org.lafeuille.demo.couchbase.data

import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CouchbaseEntityRepository : ReactiveCouchbaseRepository<CouchbaseEntity, UUID>