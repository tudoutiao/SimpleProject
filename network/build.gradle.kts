plugins {
//    id("com.android.application")
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(Configuration.AppConfigs.compile_sdk_version)


    defaultConfig {
//        applicationId = "com.my.network"
        // 最低支持版本
        minSdkVersion(Configuration.AppConfigs.min_sdk_version)
        // 目标 SDK 版本
        targetSdkVersion(Configuration.AppConfigs.target_sdk_version)
        // 应用版本号
//        versionCode = Configuration.AppConfigs.version_code
        // 应用版本名
//        versionName = Configuration.AppConfigs.version_name

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        // DataBinding 开启
        dataBinding = true
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

    //retrofit
    implementation(Configuration.Dependencies.retrofit)
    api(Configuration.Dependencies.retrofit_converter_moshi)
    //网络请求拦截 日志打印
    implementation(Configuration.Dependencies.okhttp_logging)
    //kotlin moshi
    api(Configuration.Dependencies.moshi_kt)
    //需要在bean对象上使用注解@JsonClass(generateAdapter=true)
    kapt(Configuration.Dependencies.moshi_codegen)

    //test
    testImplementation(Configuration.Dependencies.test_junit)
    androidTestImplementation(Configuration.Dependencies.androidx_test_ext_junit)
    androidTestImplementation(Configuration.Dependencies.androidx_test_espresso_core)
    androidTestImplementation(Configuration.Dependencies.androidx_compose_test_ui)
    debugImplementation(Configuration.Dependencies.androidx_compose_test_tool)


}