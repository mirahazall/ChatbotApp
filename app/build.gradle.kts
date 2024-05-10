plugins {
    alias(libs.plugins.androidApplication)
}

android {
    namespace = "com.example.chatbotapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.chatbotapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.retrofit2:converter-scalars:2.9.0")
    implementation ("com.squareup.okhttp3:okhttp:4.9.1")
    implementation ("dev.langchain4j:langchain4j-open-ai:0.30.0")
    implementation ("org.json:json:20210307")
    implementation ("com.google.mlkit:smart-reply:17.0.3")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.11.0")


}