// Top-level build file where you can add configuration options common to all sub-projects/modules.
import io.gitlab.arturbosch.detekt.Detekt

plugins {
    id(Dependencies.Plugins.ktlint) version Dependencies.Plugins.Version.ktlint
    id(Dependencies.Plugins.detekt) version Dependencies.Plugins.Version.detekt
}

buildscript {
    val kotlin_version by extra("1.4.32")
    repositories {
        google()
        jcenter()
        mavenCentral()
    }
    dependencies {
        classpath(Dependencies.ClassPath.gradle)
        classpath(Dependencies.ClassPath.kotlinGradlePlugin)
        classpath(Dependencies.ClassPath.navigationSafeArgsPlugin)

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
    }
}

subprojects {
    apply {
        plugin(Dependencies.Plugins.ktlint)
        plugin(Dependencies.Plugins.detekt)
    }

    ktlint {
        android.set(true)
        version.set(Dependencies.ThirdParty.Version.ktlint)
        outputToConsole.set(true)
        outputColorName.set("RED")
        filter {
            exclude("**/generated/**")
        }
    }

    detekt {
        buildUponDefaultConfig = true // preconfigure defaults
        allRules = false // activate all available (even unstable) rules.
        config = files("$projectDir/config/detekt/detekt.yml") // point to your custom config defining rules to run, overwriting default behavior

        reports {
            html {
                enabled = true
                destination = file("build/reports/detekt.html")
            }
        }
    }
}

tasks {
    register("clean", Delete::class) {
        delete(rootProject.buildDir)
    }

    withType<Detekt>().configureEach {
        // Target version of the generated JVM bytecode. It is used for type resolution.
        jvmTarget = AppConfig.javaJvmTarget
    }
}
