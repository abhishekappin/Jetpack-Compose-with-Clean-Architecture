object Dependencies {

    object Plugins{
        val androidApplication by lazy { "com.android.application" }
        val kotlinAndroid by lazy { "org.jetbrains.kotlin.android" }
        val hiltAndroid by lazy { "com.google.dagger.hilt.android" }
        val kotlinKapt by lazy { "org.jetbrains.kotlin.kapt" }
    }

    object DefaultConfig {
        val nameSpace by lazy { "com.appinventiv.cleanarchitecturecompose" }
        val testInstrumentationRunner by lazy { "androidx.test.runner.AndroidJUnitRunner" }
        val compileSDK by lazy { 34 }
        val minSDK by lazy { 24 }
        val targetSDK by lazy { 34 }
        val versionCode by lazy { 1 }
        val versionName by lazy { "1.0" }

    }

    object CoreLibraries {
        val coreKtx by lazy { "androidx.core:core-ktx:${Versions.coreKtx}" }
        val lifecycleKtx by lazy { "androidx.lifecycle:lifecycle-runtime-ktx:${Versions.lifecycleKtx}" }
        val composeKtx by lazy { "androidx.activity:activity-compose:${Versions.composeKtx}" }
        val composeBom by lazy { "androidx.compose:compose-bom:${Versions.composeBom}" }
        val composeUI by lazy { "androidx.compose.ui:ui" }
        val composeGraphics by lazy { "androidx.compose.ui:ui-graphics" }
        val composePreview by lazy { "androidx.compose.ui:ui-tooling-preview" }
        val composeMaterial by lazy { "androidx.compose.material3:material3" }

        // Hilt
        val hiltKtx by lazy { "com.google.dagger:hilt-android:${Versions.hiltKtx}" }
        val hiltCompiler by lazy { "com.google.dagger:hilt-android-compiler:${Versions.hiltKtx}" }
        // Hilt Navigation
        val hiltNavigation by lazy { "androidx.hilt:hilt-navigation-compose:${Versions.hiltNavigation}" }
        // Retrofit
        val retrofit by lazy { "com.squareup.retrofit2:retrofit:${Versions.retrofit}" }
        val gsonConverter by lazy { "com.squareup.retrofit2:converter-gson:${Versions.retrofit}" }
    }

    object TestingLibraries {
        val junit by lazy { "junit:junit:${Versions.junit}" }
        val junitTest by lazy { "androidx.test.ext:junit:${Versions.junitTest}" }
        val espressoCore by lazy { "androidx.test.espresso:espresso-core:${Versions.espressoCore}" }
        val composeUIJunit by lazy { "androidx.compose.ui:ui-test-junit4" }
        val composeUITooling by lazy { "androidx.compose.ui:ui-tooling" }
        val composeUITest by lazy { "androidx.compose.ui:ui-test-manifest" }
    }
}