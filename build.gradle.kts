plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "5.0.0"
}

group = "net.nachtbeere.minecraft"
version = "0.2-SNAPSHOT"

repositories {
    mavenCentral()
    maven {
        url = uri("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
        content {
            includeGroup("org.bukkit")
            includeGroup("org.spigotmc")
        }
    }
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
}

val shadowImplementation by configurations.creating
configurations["compileOnly"].extendsFrom(shadowImplementation)
configurations["testImplementation"].extendsFrom(shadowImplementation)

dependencies {
    implementation(kotlin("stdlib-jdk8"))
    compileOnly("org.spigotmc:spigot-api:1.15.2-R0.1-SNAPSHOT")
    compileOnly("org.bukkit:bukkit:1.15.2-R0.1-SNAPSHOT")
}

tasks {
    compileKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
    compileTestKotlin {
        kotlinOptions.jvmTarget = "1.8"
    }
}