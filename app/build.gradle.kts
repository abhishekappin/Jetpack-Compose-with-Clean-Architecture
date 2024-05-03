plugins {
    id(Dependencies.Plugins.androidApplication)
    id(Dependencies.Plugins.kotlinAndroid)
//    kotlin("kapt")
    id(Dependencies.Plugins.hiltAndroid)
    id(Dependencies.Plugins.kotlinKapt)
}

android {
    namespace = Dependencies.DefaultConfig.nameSpace
    compileSdk = Dependencies.DefaultConfig.compileSDK

    defaultConfig {
        applicationId = Dependencies.DefaultConfig.nameSpace
        minSdk = Dependencies.DefaultConfig.minSDK
        targetSdk = Dependencies.DefaultConfig.targetSDK
        versionCode = Dependencies.DefaultConfig.versionCode
        versionName = Dependencies.DefaultConfig.versionName

        testInstrumentationRunner = Dependencies.DefaultConfig.testInstrumentationRunner
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(Dependencies.CoreLibraries.coreKtx)
    implementation(Dependencies.CoreLibraries.lifecycleKtx)
    implementation(Dependencies.CoreLibraries.composeKtx)
    implementation(platform(Dependencies.CoreLibraries.composeBom))
    implementation(Dependencies.CoreLibraries.composeUI)
    implementation(Dependencies.CoreLibraries.composeGraphics)
    implementation(Dependencies.CoreLibraries.composePreview)
    implementation(Dependencies.CoreLibraries.composeMaterial)

    // Hilt
    implementation(Dependencies.CoreLibraries.hiltKtx)
    kapt(Dependencies.CoreLibraries.hiltCompiler)

    // Hilt-Navigation
    implementation(Dependencies.CoreLibraries.hiltNavigation)

    // Retrofit
    implementation(Dependencies.CoreLibraries.retrofit)
    implementation(Dependencies.CoreLibraries.gsonConverter)

    // Lifecycle Compose

    // Testing Library
    testImplementation(Dependencies.TestingLibraries.junit)
    androidTestImplementation(Dependencies.TestingLibraries.junitTest)
    androidTestImplementation(Dependencies.TestingLibraries.espressoCore)
    androidTestImplementation(platform(Dependencies.CoreLibraries.composeBom))
    androidTestImplementation(Dependencies.TestingLibraries.composeUITest)
    debugImplementation(Dependencies.TestingLibraries.composeUITooling)
    debugImplementation(Dependencies.TestingLibraries.composeUITest)
}