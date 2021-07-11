plugins {
    id(Dependencies.Plugins.javaLibrary)
    id(Dependencies.Plugins.kotlin)
}

java {
    sourceCompatibility = AppConfig.javaCompatibility
    targetCompatibility = AppConfig.javaCompatibility
}

dependencies {
    implementation(Dependencies.Android.kotlinStdLibJdk8)
    implementation(Dependencies.Android.kotlinxCoroutinesAndroid)
}
