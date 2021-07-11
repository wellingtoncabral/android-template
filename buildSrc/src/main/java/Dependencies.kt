object Dependencies {

    object ClassPath {

        object Version {
            const val gradle = "4.1.3"
            const val kotlin = "1.4.31"
        }

        const val gradle = "com.android.tools.build:gradle:${Version.gradle}"
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Version.kotlin}"
    }

    object Plugins {

        object Version {
            const val detekt = "1.16.0"
            const val ktlint = "10.0.0"
        }

        const val application = "com.android.application"
        const val android = "android"
        const val javaLibrary = "java-library"
        const val kotlin = "kotlin"
        const val kapt = "kapt"
        const val detekt = "io.gitlab.arturbosch.detekt"
        const val ktlint = "org.jlleitschuh.gradle.ktlint"
        const val parcelize = "kotlin-parcelize"
    }

    object Android {

        object Version {
            const val coreKtx = "1.3.2"
            const val appcompat = "1.2.0"
            const val constraintLayout = "2.0.4"
            const val materialDesign = "1.3.0"
            const val coroutines = "1.4.3"
            const val room = "2.2.6"
            const val lifecycle = "2.3.1"
        }

        const val kotlinStdLibJdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${ClassPath.Version.kotlin}"
        const val appcompat = "androidx.appcompat:appcompat:${Version.appcompat}"
        const val coreKtx = "androidx.core:core-ktx:${Version.coreKtx}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Version.constraintLayout}"
        const val materialDesign = "com.google.android.material:material:${Version.materialDesign}"
        const val kotlinxCoroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Version.coroutines}"

        // Room
        const val room = "androidx.room:room-runtime:${Version.room}"
        const val roomKapt = "androidx.room:room-compiler:${Version.room}"
        const val roomKtx = "androidx.room:room-ktx:${Version.room}"

        // Jetpack lifecycle
        const val lifecycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Version.lifecycle}"
        const val lifecycleLiveDataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:${Version.lifecycle}"
        const val lifecycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Version.lifecycle}"
    }

    object ThirdParty {

        object Version {
            const val retrofit = "2.7.2"
            const val retrofitGson = "2.6.1"
            const val leakCanary = "2.7"
            const val ktlint = "0.41.0"
            const val koin = "3.0.1"
        }

        const val retrofit = "com.squareup.retrofit2:retrofit:${Version.retrofit}"
        const val retrofitGson = "com.squareup.retrofit2:converter-gson:${Version.retrofitGson}"
        const val leakCanary = "com.squareup.leakcanary:leakcanary-android:${Version.leakCanary}"

        // Koin
        const val koinAndroid = "io.insert-koin:koin-android:${Version.koin}"
        const val koinAndroidExt = "io.insert-koin:koin-android-ext:${Version.koin}"
    }

    object Test {

        object Version {
            const val junit = "4.12"
            const val mockk = "1.9.3"
            const val archCoreTesting = "2.1.0"
        }

        const val junit = "junit:junit:${Version.junit}"
        const val mockk = "io.mockk:mockk-android:${Version.mockk}"
        const val kotlinxCoroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Android.Version.coroutines}"
        const val archCoreTesting = "androidx.arch.core:core-testing:${Version.archCoreTesting}"
        const val roomTesting = "androidx.room:room-testing:${Android.Version.room}"
    }

    object AndroidTest {

        object Version {
            const val extJunit = "1.1.2"
            const val espresso = "3.3.0"
        }

        const val extJUnit = "androidx.test.ext:junit:${Version.extJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Version.espresso}"
    }

}