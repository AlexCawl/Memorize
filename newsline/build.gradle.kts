plugins {
    id("feature-module-setup")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "newsline".asModuleName()
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:persistence"))
}