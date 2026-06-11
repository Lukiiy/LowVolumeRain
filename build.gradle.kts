plugins {
    id("babric-loom") version "1.5-SNAPSHOT"
    id("maven-publish")
}

val archivesBaseName = rootProject.property("name")!!.toString().lowercase()

group = rootProject.property("group")!!
version = rootProject.property("version")!!

base.archivesName.set(archivesBaseName)

repositories {
    maven("https://maven.glass-launcher.net/babric")
}

val minecraft = project.property("minecraft_version")!!
val loader = project.property("loader_version")!!
val yarnMappings = project.property("yarn_mappings")!!

loom {
    gluedMinecraftJar()
    customMinecraftManifest.set("https://babric.github.io/manifest-polyfill/$minecraft.json")
    intermediaryUrl.set("https://maven.glass-launcher.net/babric/babric/intermediary/%1\$s/intermediary-%1\$s-v2.jar")
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraft")
    mappings("babric:barn:$yarnMappings:v2")
    modImplementation("babric:fabric-loader:$loader")

    implementation("org.slf4j:slf4j-api:1.8.0-beta4")
    implementation("org.apache.logging.log4j:log4j-slf4j18-impl:2.16.0")
}

tasks {
    jar {
        from("LICENSE") {
            rename { "${it}_${archivesBaseName}" }
        }
    }

    processResources {
        inputs.property("version", project.version)

        filesMatching("fabric.mod.json") {
            expand(mapOf("version" to project.version))
        }
    }
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(8))
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    withSourcesJar()
}