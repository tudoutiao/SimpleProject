plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version Configuration.Versions.kotlin_version
    id("kotlin-parcelize")
}

android {
    compileSdkVersion(30)

    defaultConfig {
        applicationId = "com.my.composeapp"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    signingConfigs {
        // 签名配置
        getByName("debug") {

        }
        create("release") {

        }
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }

        getByName("debug") {
            isMinifyEnabled  = true
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
        useIR = true
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Configuration.Versions.compose_version
        kotlinCompilerVersion = "1.5.21"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    implementation(Configuration.Dependencies.androidx_core_ktx)
    implementation(Configuration.Dependencies.androidx_appcompat)
    implementation(Configuration.Dependencies.androidx_material)
    implementation(Configuration.Dependencies.androidx_compose_ui)
    implementation(Configuration.Dependencies.androidx_compose_material)
    implementation(Configuration.Dependencies.androidx_compose_preview)
    implementation(Configuration.Dependencies.androidx_lifecycle_ktx)
    implementation(Configuration.Dependencies.androidx_compose_activity)
    //test
    testImplementation(Configuration.Dependencies.test_junit)
    androidTestImplementation(Configuration.Dependencies.androidx_test_ext_junit)
    androidTestImplementation(Configuration.Dependencies.androidx_test_espresso_core)
    androidTestImplementation(Configuration.Dependencies.androidx_compose_test_ui)
    debugImplementation(Configuration.Dependencies.androidx_compose_test_tool)
}