plugins {
    id("com.gradle.enterprise") version ("3.16")
}

rootProject.name = "demo-spring-reactive"

gradleEnterprise {
    buildScan {
        termsOfServiceUrl = "https://gradle.com/terms-of-service"
        termsOfServiceAgree = "yes"
    }
}

include("shared")
include("infra-elasticsearch")
include("infra-mongo")
include("infra-neo4j")
include("infra-r2dbc")
include("books-neo4j")
include("elasticsearch")
include("people-r2dbc")
include("stores-mongo")
include("application")
