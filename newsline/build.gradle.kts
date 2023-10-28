plugins {
    id("feature-module-setup")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "newsline".asModuleName()
}

dependencies {
    implementation(project(":newsline:di"))
    implementation(project(":core:di"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:persistence"))
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.1")
}