plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.4.1"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:2024.0.0"))

    constraints {
        testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
        testImplementation(kotlin("test"))
    }
}
