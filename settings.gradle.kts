pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MemorizeApplication"
include(":app")
include(":core:network")
include(":core:ui")
include(":core:persistence")
include(":newsline")
include(":newsline:di")
include(":core:di")
include(":core:common")
