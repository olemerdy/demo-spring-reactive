package org.lafeuille.demo.echo.data

import org.springframework.data.elasticsearch.repository.ReactiveElasticsearchRepository

interface EchoRepository : ReactiveElasticsearchRepository<Echo, String>
