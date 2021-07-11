plugins {
    id(Dependencies.Plugins.application)
    kotlin(Dependencies.Plugins.android)
    kotlin(Dependencies.Plugins.kapt)
    id(Dependencies.Plugins.parcelize)
    id(Dependencies.Plugins.navigation_safe_args_kotlin)
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion(AppConfig.buildToolsVersion)

    defaultConfig {
        applicationId = AppConfig.applicationId
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode = AppConfig.versionCode
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(false)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        /* You don’t have to create debug because it’s there by default until unless
         * needed to change some properties. If so then do something like this.
         */
//        getByName("debug") {
//            minifyEnabled = false
//        }
    }

    flavorDimensions(AppConfig.dimension)
    productFlavors {
        create("staging") {
            applicationIdSuffix = ".staging"
            dimension = AppConfig.dimension
        }

        create("production") {
            dimension = AppConfig.dimension
        }
    }

    buildFeatures {
        viewBinding = true
        dataBinding = true
    }

    compileOptions {
        sourceCompatibility = AppConfig.javaCompatibility
        targetCompatibility = AppConfig.javaCompatibility
    }

    kotlinOptions {
        jvmTarget = AppConfig.javaJvmTarget
    }
}

dependencies {
    // Standalone
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    // Modules
    implementation(project(":domain"))
    implementation(project(":data"))

    // Android
    implementation(Dependencies.Android.kotlinStdLibJdk8)
    implementation(Dependencies.Android.appcompat)
    implementation(Dependencies.Android.coreKtx)
    implementation(Dependencies.Android.constraintLayout)
    implementation(Dependencies.Android.materialDesign)
    implementation(Dependencies.Android.room)
    implementation(Dependencies.Android.roomKtx)
    implementation(Dependencies.Android.lifecycleViewModelKtx)
    implementation(Dependencies.Android.lifecycleLiveDataKtx)
    implementation(Dependencies.Android.lifecycleCommonJava8)
    implementation(Dependencies.Android.navigationFragmentKtx)
    implementation(Dependencies.Android.navigationUiKtx)
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")

    // Kapt
    kapt(Dependencies.Android.roomKapt)

    // ThirdParty
    implementation(Dependencies.ThirdParty.retrofit)
    implementation(Dependencies.ThirdParty.retrofitGson)
    implementation(Dependencies.ThirdParty.koinAndroid)
    implementation(Dependencies.ThirdParty.koinAndroidExt)

    // Test
    testImplementation(Dependencies.Test.junit)
    testImplementation(Dependencies.Test.mockk)
    testImplementation(Dependencies.Test.kotlinxCoroutinesTest)
    testImplementation(Dependencies.Test.archCoreTesting)
    testImplementation(Dependencies.Test.roomTesting)

    // Android Test
    androidTestImplementation(Dependencies.AndroidTest.extJUnit)
    androidTestImplementation(Dependencies.AndroidTest.espressoCore)
    androidTestImplementation(Dependencies.AndroidTest.navigation)

    // Debug
    debugImplementation(Dependencies.ThirdParty.leakCanary)
}
