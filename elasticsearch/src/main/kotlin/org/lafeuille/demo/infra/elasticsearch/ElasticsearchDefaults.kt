package org.lafeuille.demo.infra.elasticsearch

object ElasticsearchDefaults {
    const val VERSION = "8.10.3"
    const val DOCKER_IMAGE_NAME = "docker.elastic.co/elasticsearch/elasticsearch:$VERSION"
}