plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.fadlurahmanf.starterappcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.fadlurahmanf.starterappcompose"
        minSdk = 21
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        buildConfig = true
        compose = true
    }

    flavorDimensions.add("environment")

    productFlavors {
        create("fake") {
            dimension = "environment"
            buildConfigField(
                "String",
                "BASE_MERCHANT_URL",
                "\"https://merchant.bankmas.fake\""
            )
            applicationIdSuffix = ".fake"
            resValue("string", "app_name", "Jetpack Compose Fake")
        }

        create("dev") {
            dimension = "environment"
            buildConfigField("String", "BASE_MERCHANT_URL", "\"https://merchant.bankmas.my.id\"")
            applicationIdSuffix = ".dev"
            resValue("string", "app_name", "Jetpack Compose Dev")
        }

        create("staging") {
            dimension = "environment"
            buildConfigField("String", "BASE_MERCHANT_URL", "\"https://merchant.bankmas.link\"")
            applicationIdSuffix = ".staging"
            resValue("string", "app_name", "Jetpack Compose Staging")
        }

        create("prod") {
            dimension = "environment"
            buildConfigField("String", "BASE_MERCHANT_URL", "\"https://merchant.bankmas.net\"")
            resValue("string", "app_name", "Jetpack Compose")
        }
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // navigation
    implementation(libs.androidx.navigation.compose)

    // ed25519 -> reference: https://mvnrepository.com/artifact/org.bouncycastle/bcprov-jdk15on/1.70
    implementation(libs.bcprov.jdk15on)

    implementation(libs.hilt.android.v251)
    kapt(libs.hilt.compiler)
    implementation(libs.androidx.hilt.navigation.compose)

    implementation(libs.retrofit)
    implementation(libs.converter.gson)

    implementation(libs.rxandroid)
    implementation(libs.rxjava)
    // reference: https://github.com/akarnokd/RxJavaRetrofitAdapter
    implementation(libs.rxjava3.retrofit.adapter)
    implementation(libs.logging.interceptor)
}

kapt {
    correctErrorTypes = true
}