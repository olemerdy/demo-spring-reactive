package org.lafeuille.demo.cassandra.data

import org.springframework.data.cassandra.repository.ReactiveCassandraRepository
import java.util.*

interface CassandraEntityRepository : ReactiveCassandraRepository<CassandraEntity, UUID>