plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.2.4"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:2023.0.0"))

    constraints {
        testImplementation("org.mockito.kotlin:mockito-kotlin:5.2.1")
        testRuntimeOnly("org.apache.commons:commons-compress:1.26.1")
    }
}