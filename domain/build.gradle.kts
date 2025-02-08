plugins {
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

dependencies{
    implementation(project(Modules.data))
    implementation(libs.hilt.core)
    ksp(libs.hilt.android.compiler)
}