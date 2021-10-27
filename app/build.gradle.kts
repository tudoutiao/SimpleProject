plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    kotlin("plugin.serialization") version Configuration.Versions.kotlin_version
    id("kotlin-parcelize")
    id("kotlin-android")
}

android {
    compileSdkVersion(Configuration.AppConfigs.compile_sdk_version)


    defaultConfig {
        applicationId = "com.my.composeapp"
        // 最低支持版本
        minSdkVersion(Configuration.AppConfigs.min_sdk_version)
        // 目标 SDK 版本
        targetSdkVersion(Configuration.AppConfigs.target_sdk_version)

        // 应用版本号
        versionCode = Configuration.AppConfigs.version_code
        // 应用版本名
        versionName = Configuration.AppConfigs.version_name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

//    signingConfigs {
//        // 签名配置
//        getByName("debug") {
//
//        }
//        create("release") {
//
//        }
//    }

//    buildTypes {
//        getByName("release") {
//            isMinifyEnabled = false
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//
//        getByName("debug") {
//            isMinifyEnabled = true
//            proguardFiles(
//                getDefaultProguardFile("proguard-android-optimize.txt"),
//                "proguard-rules.pro"
//            )
//        }
//    }


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
        viewBinding = true
        dataBinding = true
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
    //协程
    implementation(Configuration.Dependencies.kotlin_coroutines)
    implementation(Configuration.Dependencies.kotlin_coroutines_android)
    //

    implementation(project(mapOf("path" to ":network")))
    implementation(Configuration.Dependencies.androidx_constraint)
    implementation(Configuration.Dependencies.androidx_lifecycle_livedata_ktx)
    implementation(Configuration.Dependencies.androidx_lifecycle_viewmodel_ktx)
    implementation(Configuration.Dependencies.androidx_navigation_fragment_ktx)
    implementation(Configuration.Dependencies.androidx_navigation_ui_ktx)
    //test
    testImplementation(Configuration.Dependencies.test_junit)
    androidTestImplementation(Configuration.Dependencies.androidx_test_ext_junit)
    androidTestImplementation(Configuration.Dependencies.androidx_test_espresso_core)
    androidTestImplementation(Configuration.Dependencies.androidx_compose_test_ui)
    debugImplementation(Configuration.Dependencies.androidx_compose_test_tool)
}