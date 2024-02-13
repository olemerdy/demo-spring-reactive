package org.lafeuille.demo.elasticsearch.data

import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.elasticsearch.annotations.Document
import java.time.Instant
import java.util.UUID

@Document(indexName = "entities")
data class ElasticsearchEntity(
    @Id val id: UUID = UUID.randomUUID(),
    @CreatedDate val createdDate: Instant? = null,
    @LastModifiedDate val lastModifiedDate: Instant? = null,
    @Version val version: Long? = null,
)
