import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.6.4"
	id("io.spring.dependency-management") version "1.0.11.RELEASE"
	kotlin("jvm") version "1.6.10"
	kotlin("plugin.spring") version "1.6.10"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("aws.sdk.kotlin:s3:0.13.0-beta"){
		exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-core")
//		exclude(group = "org.jetbrains.kotlinx", module = "kotlinx-coroutines-core-jvm")
	}
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0")
//	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.0")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
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
