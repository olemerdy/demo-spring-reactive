plugins {
    `kotlin-dsl`
}

repositories {
    mavenCentral()
    gradlePluginPortal()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:$embeddedKotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-allopen:$embeddedKotlinVersion")
    implementation("com.diffplug.spotless:spotless-plugin-gradle:${libs.versions.spotless.get()}")
    implementation("io.spring.gradle:dependency-management-plugin:${libs.versions.spring.dependency.management.get()}")

    implementation(files(libs.javaClass.superclass.protectionDomain.codeSource.location))
}
