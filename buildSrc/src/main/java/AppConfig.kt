import org.gradle.api.JavaVersion

// App level config constants
object AppConfig {
    const val compileSdk = 30
    const val minSdk = 23
    const val targetSdk = 30
    const val applicationId = "com.br.wcabral.kotlin.android.androidtemplate"
    const val versionCode = 1
    const val versionName = "1.0.0"
    const val buildToolsVersion = "30.0.3"

    const val androidTestInstrumentation = "androidx.test.runner.AndroidJUnitRunner"
    const val dimension = "environment"

    const val javaJvmTarget = "1.8"
    val javaCompatibility = JavaVersion.VERSION_1_8
}