plugins {
    id("com.android.application")
//    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}


android {
    compileSdk = Configuration.AppConfigs.compile_sdk_version


    defaultConfig {
        applicationId = "com.my.news"
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
        compose = true
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
//    api(project(":common"))
    api(project(":network"))
    api(project(":base"))
    implementation(Configuration.Dependencies.androidx_activity)
    implementation(Configuration.Dependencies.androidx_activity_ktx)
    implementation(Configuration.Dependencies.androidx_viewpager2)
    implementation(Configuration.Dependencies.androidx_fragment_ktx)
    implementation(Configuration.Dependencies.androidx_material)
    implementation(Configuration.Dependencies.androidx_core_ktx)
    implementation(Configuration.Dependencies.androidx_appcompat)
    implementation(Configuration.Dependencies.androidx_constraint)
    implementation(Configuration.Dependencies.androidx_legacy)
    implementation(Configuration.Dependencies.androidx_lifecycle_viewmodel_ktx)
    implementation(Configuration.Dependencies.androidx_lifecycle_livedata_ktx)

}