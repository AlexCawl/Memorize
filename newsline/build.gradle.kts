plugins {
    id("feature-module-setup")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "newsline".asModuleName()
}

dependencies {
    implementation(project(":newsline:di"))
    implementation(project(":core:common"))
    implementation(project(":core:di"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:persistence"))
}