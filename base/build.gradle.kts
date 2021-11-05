plugins {
//    id("com.android.application")
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}
android {
    compileSdk = Configuration.AppConfigs.compile_sdk_version

    defaultConfig {
//        applicationId "com.my.base"
        minSdk = (Configuration.AppConfigs.min_sdk_version)
        targetSdk = Configuration.AppConfigs.target_sdk_version

        // 应用版本号
//        versionCode = Configuration.AppConfigs.version_code
        // 应用版本名
//        versionName = Configuration.AppConfigs.version_name

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

    implementation(Configuration.Dependencies.androidx_core_ktx)
    implementation(Configuration.Dependencies.androidx_appcompat)
    implementation(Configuration.Dependencies.androidx_material)
    implementation(Configuration.Dependencies.androidx_constraint)
    implementation(Configuration.Dependencies.androidx_lifecycle_ktx)
    implementation(Configuration.Dependencies.androidx_activity)
    implementation(Configuration.Dependencies.androidx_activity_ktx)
    //解决livedata倒灌
    implementation(Configuration.Dependencies.unpeek_livedata)
}