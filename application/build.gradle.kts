import org.springframework.boot.gradle.tasks.bundling.BootBuildImage

plugins {
    `project-kotlin-jvm`
    `project-kotlin-spring`
    alias(libs.plugins.gorylenko.git.properties)
    alias(libs.plugins.spring.boot)
    id("maven-publish")
    `jacoco-report-aggregation`
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

gitProperties {
    dotGitDirectory =
        project.rootProject.layout.projectDirectory
            .dir(".git")
}

springBoot {
    mainClass = "org.lafeuille.demo.ApplicationKt"
    buildInfo()
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

tasks.check {
    dependsOn(tasks.named<JacocoReport>("testCodeCoverageReport"))
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":infra-elasticsearch"))
    implementation(project(":infra-mongo"))
    implementation(project(":infra-neo4j"))
    implementation(project(":infra-r2dbc"))
    implementation(project(":books-neo4j"))
    implementation(project(":contents-elasticsearch"))
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

    testAndDevelopmentOnly("org.springframework.boot:spring-boot-devtools")
    testAndDevelopmentOnly("org.springframework.boot:spring-boot-docker-compose")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation("io.projectreactor:reactor-test")
}
