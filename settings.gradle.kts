plugins {
    id("com.gradle.enterprise") version("3.16")
}

rootProject.name = "demo-spring-reactive"

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

include("shared")
include("books-neo4j")
include("elasticsearch")
include("people-r2dbc")
include("redis")
include("stocks-cassandra")
include("stores-mongo")
include("application")
