plugins {
    id("application-module-setup")
}

dependencies {
    implementation(project(":newsline"))
    implementation(project(":core:di"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:persistence"))
}