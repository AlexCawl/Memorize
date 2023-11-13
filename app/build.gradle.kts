plugins {
    id("application-module-setup")
}

dependencies {
    implementation(project(":newsline"))
    implementation(project(":newsline:di"))

    implementation(project(":core:common"))
    implementation(project(":core:di"))
    implementation(project(":core:network"))
    implementation(project(":core:ui"))
    implementation(project(":core:persistence"))
}