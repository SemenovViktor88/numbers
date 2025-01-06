plugins {
    id("java-library")
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
dependencies{
    implementation(libs.hilt.android)
    ksp(libs.hilt.android.compiler)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
}