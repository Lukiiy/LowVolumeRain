plugins {
    id("fabric-loom") version "1.17-SNAPSHOT"
    id("ploceus") version "1.17-SNAPSHOT"
}

val archivesBaseName = rootProject.property("name")!!.toString().lowercase()

group = rootProject.property("group")!!
version = rootProject.property("version")!!

base.archivesName.set("$archivesBaseName-ornithe")

val minecraft = project.property("minecraftVer")!!.toString()
val loader = project.property("loaderVer")!!.toString()
val featherBuild = project.property("feather_build")!!.toString()

ploceus {
    setIntermediaryGeneration(2)
}

dependencies {
    minecraft("com.mojang:minecraft:$minecraft")
    mappings(ploceus.featherMappings(featherBuild))
    modImplementation("net.fabricmc:fabric-loader:$loader")

    ploceus.dependOsl(project.property("osl_version")!!.toString())
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