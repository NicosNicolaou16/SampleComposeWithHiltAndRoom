buildscript {
    dependencies {
        val hiltVersion by extra("2.59.1")
        classpath("com.google.dagger:hilt-android-gradle-plugin:$hiltVersion")
    }
}// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "9.0.1" apply false
    id("com.android.library") version "9.0.1" apply false
    id("org.jetbrains.kotlin.android") version "2.3.10" apply false
    id("com.google.devtools.ksp") version "2.3.5" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "2.3.10" apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}