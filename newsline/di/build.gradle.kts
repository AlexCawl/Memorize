plugins {
    id("android-setup")
}

android {
    namespace = "newsline.di".asModuleName()
}

dependencies {
    implementation(project(":core:common"))
    implementation(project(":core:di"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:persistence"))
}