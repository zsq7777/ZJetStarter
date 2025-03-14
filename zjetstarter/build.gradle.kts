plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.jetbrains.kotlin.android)
    id("maven-publish") //  Maven 发布插件

}

android {
    namespace = "com.able.zjetstarter"
    compileSdk = 34

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {


    api(libs.androidx.core.ktx)
    api(libs.androidx.lifecycle.runtime.ktx)

    //composeUI
    api(libs.androidx.activity.compose)
    api(platform(libs.androidx.compose.bom))
    api(libs.androidx.ui)
    api(libs.androidx.ui.graphics)
    api(libs.androidx.ui.tooling.preview)
    api(libs.androidx.material3)


    //核心库及UI
    api(libs.androidx.appcompat)
    api(libs.material)
    api(libs.androidx.constraintlayout)

    //Jetpack组件
    //键值对存储
    api(libs.datastore.preferences)


    //xcrash
    api("com.iqiyi.xcrash:xcrash-android-lib:3.0.0")
    //日志记录 XLog
    api("com.elvishew:xlog:1.11.0")
    // 工具类
    api("com.blankj:utilcodex:1.31.1")
    //网络请求
    api("com.squareup.okhttp3:okhttp:4.12.0")
    api("com.squareup.okhttp3:logging-interceptor:4.12.0")
    api("com.squareup.retrofit2:retrofit:2.11.0")
    api("com.squareup.retrofit2:converter-gson:2.11.0")
    api("com.squareup.retrofit2:converter-scalars:2.8.1")
    // MQTT
    api("org.eclipse.paho:org.eclipse.paho.client.mqttv3:1.2.5")
    api("org.eclipse.paho:org.eclipse.paho.android.service:1.1.1")
    // 协程
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.9.0")
    //动效
    api("com.airbnb.android:lottie:6.3.0")

}


afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])
                groupId = "com.github.zsq7777"
                artifactId = "ZJetStarter"
                version = "0.0.2"
            }
        }
    }
}

