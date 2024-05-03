// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id(Dependencies.Plugins.androidApplication) version Versions.androidApplication apply false
    id(Dependencies.Plugins.kotlinAndroid) version Versions.kotlinAndroid apply false
    id(Dependencies.Plugins.hiltAndroid) version Versions.hiltKtx apply false
    id(Dependencies.Plugins.kotlinKapt) version Versions.kotlinKapt apply false
}