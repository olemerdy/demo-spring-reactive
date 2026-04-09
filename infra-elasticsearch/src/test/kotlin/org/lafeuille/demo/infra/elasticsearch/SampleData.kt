package org.lafeuille.demo.infra.elasticsearch

import org.springframework.data.annotation.Id
import org.springframework.data.elasticsearch.annotations.Document
import org.springframework.data.elasticsearch.annotations.Field
import org.springframework.data.elasticsearch.annotations.FieldType
import java.time.Instant
import java.util.UUID

@Document(indexName = "samples")
data class SampleData(
    @Id val id: UUID = UUID.randomUUID(),
    @Field(type = FieldType.Double) val value: Double,
    @Field(type = FieldType.Date) val timestamp: Instant,
)
