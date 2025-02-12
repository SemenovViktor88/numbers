plugins {
    alias(libs.plugins.google.ksp)
    alias(libs.plugins.jetbrains.kotlin.jvm)
}

dependencies{
    ksp(libs.hilt.android.compiler)
    implementation(libs.hilt.core)
    ksp(libs.androidx.room.compiler)
    implementation(libs.androidx.room.runtime.jvm)
    implementation(libs.androidx.room.common)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.retrofit.gson.scalars)
}