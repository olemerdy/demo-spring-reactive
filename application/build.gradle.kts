import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    embeddedKotlin("jvm")
    embeddedKotlin("plugin.spring")
    id("maven-publish")
    alias(libs.plugins.spring.boot)
    alias(libs.plugins.spring.dependencies.management)
}

repositories {
    mavenCentral()
}

publishing {
    repositories {
        maven {
            name = "GithubPackages"
            url = uri("https://maven.pkg.github.com/olemerdy/demo-spring-reactive")
            credentials {
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
    publications {
        create<MavenPublication>("bootJar") {
            artifact(tasks.named("bootJar"))
        }
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
}

springBoot {
    mainClass = "org.lafeuille.demo.ApplicationKt"
}

tasks.named<BootBuildImage>("bootBuildImage") {
    imageName.set("gchr.io/olemerdy/${project.name}:${project.version}")
    docker {
        publishRegistry {
            username = System.getenv("USERNAME")
            password = System.getenv("TOKEN")
        }
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = libs.versions.java.get()
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

dependencies {
    implementation(platform(org.springframework.boot.gradle.plugin.SpringBootPlugin.BOM_COORDINATES))
    implementation(platform(libs.spring.cloud.bom))

    implementation(project(":shared"))
    implementation(project(":infra-elasticsearch"))
    implementation(project(":infra-mongo"))
    implementation(project(":infra-neo4j"))
    implementation(project(":infra-r2dbc"))
    implementation(project(":books-neo4j"))
    implementation(project(":elasticsearch"))
    implementation(project(":people-r2dbc"))
    implementation(project(":stores-mongo"))

    implementation("org.springframework.boot:spring-boot-starter-actuator")
    implementation("org.springframework.boot:spring-boot-starter-validation")
    implementation("org.springframework.boot:spring-boot-starter-webflux")
    implementation("org.springframework.cloud:spring-cloud-starter-stream-rabbit")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation("io.projectreactor.kotlin:reactor-kotlin-extensions")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")

    developmentOnly("org.springframework.boot:spring-boot-devtools")
    developmentOnly("org.springframework.boot:spring-boot-docker-compose")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.springframework.boot:spring-boot-testcontainers")
    testImplementation("io.projectreactor:reactor-test")
    testImplementation("org.testcontainers:junit-jupiter")
    testImplementation("org.testcontainers:elasticsearch")
    testImplementation("org.testcontainers:mongodb")
    testImplementation("org.testcontainers:neo4j")
    testImplementation("org.testcontainers:postgresql")
    testImplementation("org.testcontainers:rabbitmq")
    testImplementation("org.testcontainers:r2dbc")

}