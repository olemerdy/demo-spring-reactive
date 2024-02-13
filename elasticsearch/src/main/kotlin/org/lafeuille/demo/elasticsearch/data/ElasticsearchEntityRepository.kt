package org.lafeuille.demo.elasticsearch.data

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository
import java.util.UUID

interface ElasticsearchEntityRepository : ReactiveElasticsearchRepository<ElasticsearchEntity, UUID>
