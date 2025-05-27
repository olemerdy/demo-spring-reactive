package org.lafeuille.demo.infra.elasticsearch

object ElasticsearchDefaults {
    const val VERSION = "8.17.6"
    const val DOCKER_IMAGE_NAME = "docker.elastic.co/elasticsearch/elasticsearch:$VERSION"
}
