plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.2.2"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:2023.0.0"))
}