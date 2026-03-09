package org.lafeuille.demo.contents.data

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository

interface BookContentRepository : ReactiveElasticsearchRepository<BookContent, String>
