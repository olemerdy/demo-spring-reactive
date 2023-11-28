rootProject.name = "demo-spring-reactive"

plugins {
    id("com.gradle.enterprise") version("3.15.1")
}

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

include("shared")
include("couchbase")
include("books-neo4j")
include("elasticsearch")
include("people-r2dbc")
include("redis")
include("stocks-cassandra")
include("stores-mongo")
include("application")
