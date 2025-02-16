plugins {
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

dependencies{
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.core)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.runtime)
    implementation(libs.retrofit)
}