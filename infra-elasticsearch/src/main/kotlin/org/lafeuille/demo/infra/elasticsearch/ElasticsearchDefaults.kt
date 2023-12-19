package org.lafeuille.demo.infra.elasticsearch

object ElasticsearchDefaults {
    const val VERSION = "7.17.10"
    const val DOCKER_IMAGE_NAME = "docker.elastic.co/elasticsearch/elasticsearch:$VERSION"
}