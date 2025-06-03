# TODO

* Bookstores

## Showcasing

* Autonomous modules
* Reactive Repositories

# Errors

## ElasticSearch Docker Compose

elasticsearch-1  | {"@timestamp":"2025-06-03T12:02:16.001Z", "log.level":"ERROR", "message":"node validation exception\n[2] bootstrap checks failed. You must address the points described in the following [2] lines before starting Elasticsearch. For more information see [https://www.elastic.co/guide/en/elasticsearch/reference/8.18/bootstrap-checks.html]\nbootstrap check failure [1] of [2]: max virtual memory areas vm.max_map_count [65530] is too low, increase to at least [262144]; for more information see [https://www.elastic.co/guide/en/elasticsearch/reference/8.18/bootstrap-checks-max-map-count.html]\nbootstrap check failure [2] of [2]: the default discovery settings are unsuitable for production use; at least one of [discovery.seed_hosts, discovery.seed_providers, cluster.initial_master_nodes] must be configured; for more information see [https://www.elastic.co/guide/en/elasticsearch/reference/8.18/bootstrap-checks-discovery-configuration.html]", "ecs.version": "1.2.0","service.name":"ES_ECS","event.dataset":"elasticsearch.server","process.thread.name":"main","log.logger":"org.elasticsearch.bootstrap.Elasticsearch","elasticsearch.node.name":"f16d02c0394a","elasticsearch.cluster.name":"docker-cluster"}
