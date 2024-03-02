// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val agp_version1 by extra("8.1.2")
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.42")
        classpath ("com.google.gms:google-services:4.3.13")
        classpath ("com.google.firebase:firebase-crashlytics-gradle:2.9.1")

    }
}

plugins {
    id("com.android.application") version "8.1.2" apply false
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.8.0-1.0.8" apply false
    id("com.google.dagger.hilt.android") version "2.44" apply false

}