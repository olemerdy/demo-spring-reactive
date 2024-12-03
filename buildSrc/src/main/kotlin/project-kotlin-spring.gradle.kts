plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

dependencies {
    api(platform("org.springframework.boot:spring-boot-dependencies:3.4.0"))
    api(platform("org.springframework.cloud:spring-cloud-dependencies:2024.0.0"))

    constraints {
        testImplementation("org.apache.commons:commons-compress:[1.26+,)") // Security fix for TestContainers 1.20.4
        testImplementation("org.mockito.kotlin:mockito-kotlin:5.4.0")
        testImplementation(kotlin("test"))
    }
}
