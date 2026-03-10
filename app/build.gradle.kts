plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.mood_tracker"
    compileSdk {
        version = release(36)
    }

    defaultConfig {
        applicationId = "com.example.mood_tracker"
        minSdk = 24
        targetSdk = 36
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
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
}
 //dependencies {
    //implementation(libs.appcompat)
   // implementation(libs.material)
   // implementation(libs.activity)
   // implementation(libs.constraintlayout)
  //  implementation("androidx.room:room-runtime:2.6.1")
   // implementation(libs.androidx.recyclerview)
   // implementation(libs.room.runtime)
 //   implementation(libs.androidx.room.ktx)
  //  annotationProcessor("androidx.room:room-compiler:2.6.1")
  //  testImplementation(libs.junit)
 //   androidTestImplementation(libs.ext.junit)
//    androidTestImplementation(libs.espresso.core)
 //   annotationProcessor(libs.room.compiler)
//}