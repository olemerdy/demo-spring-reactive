import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

val libs = the<LibrariesForLibs>()

dependencyManagement {
    imports {
        mavenBom("org.springframework.boot:spring-boot-dependencies:${libs.versions.spring.boot.get()}")
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${libs.versions.spring.cloud.get()}")
    }
    dependencies {
        dependency("org.mockito.kotlin:mockito-kotlin:${libs.versions.mockito.kotlin.get()}")
    }
}

dependencies {
    constraints {
        testImplementation(kotlin("test"))
    }
}
