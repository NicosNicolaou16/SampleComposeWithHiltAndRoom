plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.devtools.ksp")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdk = 34
    buildToolsVersion = "34.0.0"
    namespace = "com.nick.samplecomposewithhiltandroom"

    defaultConfig {
        applicationId = "com.nick.samplecomposewithhiltandroom"
        minSdk = 27
        targetSdk = 34
        versionCode = 1
        versionName = "1.0.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isShrinkResources = true
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isShrinkResources = true
            isMinifyEnabled = true
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
        jvmTarget = JavaVersion.VERSION_17.toString()
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.6"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

val appCompatVersion by extra("1.6.1")
val coreKtxVersion by extra("1.12.0")
val lifeCycleAndLiveDataCompilerAndViewModelKTXVersion by extra("2.6.2")
val swipeRefreshLayoutVersion by extra("1.1.0")
val activityVersion by extra("1.8.1")
val fragmentVersion by extra("1.6.2")
val retrofitVersion by extra("2.9.0")
val okHttpVersion by extra("4.12.0")
val roomVersion by extra("2.6.1")
val daggerVersion by extra("2.15")
val coroutineVersion by extra("1.7.3")
val multidexVersion by extra("2.0.1")
val materialDesignVersion by extra("1.10.0")
val coilVersion by extra("2.5.0")
val hiltVersion by extra("2.49")
val hiltCompilerVersion by extra("1.1.0")
val composeCompilerVersion by extra("1.5.6")
val composeVersion by extra("1.5.4")
val composeFoundationVersion by extra("1.5.4")
val composeMaterialVersion by extra("1.5.4")
val composeMaterial3Version by extra("1.1.2")
val composeNavigationVersion by extra("2.7.5")
val composeHiltNavigationVersion by extra("1.1.0")

dependencies {
    //Architecture Library
    implementation("androidx.activity:activity-ktx:$activityVersion")
    implementation("androidx.fragment:fragment-ktx:$fragmentVersion")
    implementation("androidx.appcompat:appcompat:$appCompatVersion")
    implementation("androidx.core:core-ktx:$coreKtxVersion")
    implementation("androidx.swiperefreshlayout:swiperefreshlayout:$swipeRefreshLayoutVersion")
    //View Model KTX and LiveData and Live Cycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifeCycleAndLiveDataCompilerAndViewModelKTXVersion")
    //noinspection LifecycleAnnotationProcessorWithJava8
    kapt("androidx.lifecycle:lifecycle-compiler:$lifeCycleAndLiveDataCompilerAndViewModelKTXVersion")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifeCycleAndLiveDataCompilerAndViewModelKTXVersion")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifeCycleAndLiveDataCompilerAndViewModelKTXVersion")
    //Unit Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    //Room Database
    implementation("androidx.room:room-runtime:$roomVersion")
    ksp("androidx.room:room-compiler:$roomVersion")
    implementation("androidx.room:room-ktx:$roomVersion")
    //Retrofit request
    implementation("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation("com.squareup.retrofit2:converter-gson:$retrofitVersion")
    implementation("com.squareup.retrofit2:adapter-rxjava2:$retrofitVersion")
    //Coil load Image
    implementation("io.coil-kt:coil-compose:$coilVersion")
    //Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:$coroutineVersion")
    //Materials
    implementation("com.google.android.material:material:$materialDesignVersion")
    //Hilt
    implementation("com.google.dagger:hilt-android:$hiltVersion")
    ksp("com.google.dagger:hilt-compiler:$hiltVersion")
    ksp("androidx.hilt:hilt-compiler:$hiltCompilerVersion")
    //Multidex
    implementation("androidx.multidex:multidex:$multidexVersion")
    //Compose
    implementation("androidx.compose.compiler:compiler:$composeCompilerVersion")
    implementation("androidx.compose.foundation:foundation:$composeFoundationVersion")
    implementation("androidx.compose.material:material:$composeMaterialVersion")
    implementation("androidx.compose.material3:material3:$composeMaterial3Version")
    implementation("androidx.compose.runtime:runtime:$composeVersion")
    implementation("androidx.compose.runtime:runtime-livedata:$composeVersion")
    implementation("androidx.compose.ui:ui:$composeVersion")
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:$composeVersion")
    debugImplementation("androidx.compose.ui:ui-tooling:$composeVersion")
    implementation("androidx.compose.ui:ui-tooling-preview:$composeVersion")
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifeCycleAndLiveDataCompilerAndViewModelKTXVersion")
    implementation("androidx.activity:activity-compose:$activityVersion")
    implementation("androidx.navigation:navigation-compose:$composeNavigationVersion")
    implementation("androidx.hilt:hilt-navigation-compose:$composeHiltNavigationVersion")
}