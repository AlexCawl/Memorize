plugins {
    id("android-setup")
}

dependencies {
    // Android
    implementation(ApplicationDeps.Android.coreKtx)
    implementation(ApplicationDeps.Android.appcompat)
    implementation(ApplicationDeps.Android.material)
    implementation(ApplicationDeps.Android.constraint)
    implementation(ApplicationDeps.Android.fragment)
    implementation(ApplicationDeps.Android.viewModel)
    implementation(ApplicationDeps.Android.runtime)
    implementation(ApplicationDeps.Android.lifecycleExtensions)

    // Navigation
    implementation(ApplicationDeps.Navigation.ui)
    implementation(ApplicationDeps.Navigation.fragment)

    // Util
    implementation(ApplicationDeps.Utils.coil)

    // Testing
    androidTestImplementation(ApplicationDeps.Test.androidJunit)
    androidTestImplementation(ApplicationDeps.Test.espresso)
}

android {
    buildFeatures {
        viewBinding = true
        compose = false
    }
}