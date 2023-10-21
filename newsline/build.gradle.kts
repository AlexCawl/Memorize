plugins {
    id("feature-module-setup")
}

android {
    namespace = "newsline".asModuleName()
}

dependencies {
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:di"))
    implementation(project(":core:persistence"))
}