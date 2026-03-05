plugins {
    id("org.gradle.toolchains.foojay-resolver-convention").version("1.0.0")
}

dependencyResolutionManagement {
    repositories {
        mavenCentral()
    }
}

rootProject.name = "demo-spring-reactive"

include("infra-shared")
include("infra-cassandra")
include("infra-couchbase")
include("infra-elasticsearch")
include("infra-kafka")
include("infra-mongodb")
include("infra-neo4j")
include("infra-postgresql")
include("infra-r2dbc")
include("infra-rabbitmq")
include("infra-redis")
include("feature-elasticsearch")
include("feature-mongo")
include("feature-r2dbc")
include("application")