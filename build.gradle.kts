plugins {
    java
    id("org.springframework.boot") version "2.7.15"
    id("io.spring.dependency-management") version "1.0.15.RELEASE"
}

group = "com.polarbookshop"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_20
}

repositories {
    mavenCentral()
}

val springCloudVersion by extra("2021.0.3")
val testcontainersVersion by extra("1.17.3")

dependencies {
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-actuator")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-data-jdbc")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-validation")
    implementation(group = "org.springframework.boot", name = "spring-boot-starter-web")
    implementation(group = "org.springframework.cloud", name = "spring-cloud-starter-config")
    implementation(group = "org.springframework.retry", name = "spring-retry")
    implementation(group = "org.flywaydb", name = "flyway-core")

    runtimeOnly(group = "org.postgresql", name = "postgresql")

    testImplementation(group = "org.springframework.boot", name = "spring-boot-starter-test")
    testImplementation(group = "org.springframework.boot", name = "spring-boot-starter-webflux")
    testImplementation(group = "org.testcontainers", name = "postgresql")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
        mavenBom("org.testcontainers:testcontainers-bom:${testcontainersVersion}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
