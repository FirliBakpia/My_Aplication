plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.myapplication"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.myapplication"
        minSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    // Pustaka inti
    implementation( "androidx.core:core-ktx:1.10.1" ) //versi ori: libs.androidx.core.ktx
    implementation( "androidx.appcompat:appcompat:1.6.1") // versi ori: libs.androidx.appcompat
    implementation("com.google.android.material:material:1.11.0") // versi ori: libs.material
    implementation("androidx.activity:activity-ktx:1.9.3") // versi ori: libs.androidx.activity
    implementation("com.google.android.material:material:1.9.0") //versi ori:libs.androidx.constraintlayout

    // - - ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")

    // Gambar
    implementation("com.squareup.picasso:picasso:2.8")
    implementation("com.github.bumptech.glide:glide:4.16.0")

    // - - ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")

    // - - LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.2.0")

    // - - Retrofit2
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")
    implementation("com.squareup.retrofit2:converter-scalars:2.9.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.4.2")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.4.2")
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Pengujian
    testImplementation("junit:junit:4.13.2") //versi ori: libs.junit
    androidTestImplementation("androidx.test.ext:junit:1.1.5") //versi original:libs.androidx.junit
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") //versi ori: libs.androidx.espresso.core
}