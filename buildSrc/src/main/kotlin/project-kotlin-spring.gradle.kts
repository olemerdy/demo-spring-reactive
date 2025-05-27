import org.gradle.accessors.dm.LibrariesForLibs

plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
    id("io.spring.dependency-management")
}

val libs = the<LibrariesForLibs>()

dependencies {
    api(platform(libs.spring.boot.bom))
    api(platform(libs.spring.cloud.bom))

    constraints {
        testImplementation(libs.mockito.kotlin)
        testImplementation(kotlin("test"))
    }
}
