import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
	kotlin("plugin.jpa") version "1.6.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	runtimeOnly("com.h2database:h2")
	implementation ("net.minidev:json-smart:2.4.8")
	implementation ("com.google.code.gson:gson:2.9.0")
	implementation ("org.json:json:20211205")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation ("com.squareup.okhttp3:okhttp:5.0.0-alpha.2")
	implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")
	implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
	implementation ("com.google.code.gson:gson:2.9.0")
	implementation ("com.squareup.retrofit2:retrofit:2.9.0")
	implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "11"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
