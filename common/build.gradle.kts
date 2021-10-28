plugins {
    id("com.android.application")
//    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}


android {
    compileSdk = Configuration.AppConfigs.compile_sdk_version

    defaultConfig {
        applicationId = "com.my.common"
        minSdk = Configuration.AppConfigs.min_sdk_version
        targetSdk = Configuration.AppConfigs.target_sdk_version
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }


    buildFeatures {
        // DataBinding 开启
        dataBinding = true
        viewBinding = true
    }

    // Java 版本配置
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    api(project(":base"))
    api(Configuration.Dependencies.glide)
    annotationProcessor(Configuration.Dependencies.glide_compiler)
    implementation(Configuration.Dependencies.androidx_core_ktx)
    implementation(Configuration.Dependencies.androidx_appcompat)
    implementation(Configuration.Dependencies.androidx_material)
    implementation(Configuration.Dependencies.androidx_constraint)
}