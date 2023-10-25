plugins {
    id("application-module-setup")
}

dependencies {
    implementation(project(":newsline"))

    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:persistence"))
}