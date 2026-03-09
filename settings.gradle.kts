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
include("feature-charlie")
include("feature-echo")
include("feature-kilo")
include("feature-mike")
include("feature-november")
include("feature-papa")
include("feature-romeo")
include("feature-sierra")
include("application")