import org.gradle.api.tasks.testing.logging.TestLogEvent
import java.io.ByteArrayOutputStream

/**
 * Returns the string itself if it's not null or blank. Otherwise, returns the result
 * of the provided [defaultValueProvider] function.
 *
 * @param defaultValueProvider A function that provides a default value when the string is null or blank.
 * @return The original string if it's not null or blank; otherwise, the result of [defaultValueProvider].
 */
infix fun String?.ifNullOrBlank(defaultValueProvider: () -> String?): String? {
    return if (this.isNullOrBlank()) {
        defaultValueProvider()
    } else {
        this
    }
}

plugins {
    id("java")
    id("java-library")
    alias(libs.plugins.shadow)
    id("maven-publish")
}

group = "me.kubbidev"
version = "1.0-SNAPSHOT"

base {
    archivesName.set("noblockupdate")
}

java {
    sourceCompatibility = JavaVersion.VERSION_21
    targetCompatibility = JavaVersion.VERSION_21
    withSourcesJar()
}

repositories {
    mavenCentral()
    maven("https://repo.papermc.io/repository/maven-public/")
}

dependencies {
    compileOnly("io.papermc.paper:paper-api:1.20.4-R0.1-SNAPSHOT")

    // tests
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.0")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")
    testImplementation("org.testcontainers:junit-jupiter:1.19.8")
}

fun determinePatchVersion(): Int {
    // get the name of the last tag
    val tagInfo = ByteArrayOutputStream()
    exec {
        commandLine("git", "describe", "--tags")
        standardOutput = tagInfo
    }
    val tagString = String(tagInfo.toByteArray())
    if (tagString.contains("-")) {
        return tagString.split("-")[1].toInt()
    }
    return 0
}

val majorVersion = "1"
val minorVersion = "0"
val patchVersion = determinePatchVersion()
val releaseVersion = "$majorVersion.$minorVersion"
val projectVersion = "$releaseVersion.$patchVersion"

publishing {
    publications {
        create<MavenPublication>("maven") {
            artifactId = "noblockupdate"
            from(components["java"])
        }
    }
    repositories {
        mavenLocal()
//        maven(url = "https://kubbidev.com/nexus/repository/maven-releases/") {
//            name = "kubbidev-releases"
//            credentials(PasswordCredentials::class) {
//                username = System.getenv("GRADLE_KUBBIDEV_RELEASES_USER").ifNullOrBlank {
//                    property("kubbidev-releases-user") as String?
//                }
//                password = System.getenv("GRADLE_KUBBIDEV_RELEASES_PASS").ifNullOrBlank {
//                    property("kubbidev-releases-pass") as String?
//                }
//            }
//        }
//        maven(url = "https://nexus.guill.productions/repository/uhcworld-libs/") {
//            name = "uhcworld-internal"
//            credentials(PasswordCredentials::class) {
//                username = System.getenv("GRADLE_UW_INTERNAL_USER").ifNullOrBlank {
//                    property("uhcworld-internal-user") as String?
//                }
//                password = System.getenv("GRADLE_UW_INTERNAL_PASSWORD").ifNullOrBlank {
//                    property("uhcworld-internal-password") as String?
//                }
//            }
//        }
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}

tasks.processResources {
    filesMatching("plugin.yml") {
        expand("pluginVersion" to projectVersion)
    }
}

tasks.shadowJar {
    mergeServiceFiles()
}

tasks.publish {
    dependsOn(tasks.shadowJar)
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<Test>().configureEach {
    testLogging {
        events = setOf(TestLogEvent.PASSED, TestLogEvent.FAILED, TestLogEvent.SKIPPED)
    }
}

artifacts {
    archives(tasks.shadowJar)
}