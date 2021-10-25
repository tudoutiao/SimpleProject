buildscript {
    repositories {
        maven { setUrl("https://maven.aliyun.com/nexus/content/groups/public/") }
        maven { setUrl("https://maven.aliyun.com/nexus/content/repositories/jcenter") }

        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.0.3")
        classpath(kotlin(module = "gradle-plugin", version = Configuration.Versions.kotlin_version))
        classpath("com.github.dcendents:android-maven-gradle-plugin:1.5")
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        maven { setUrl("https://maven.aliyun.com/nexus/content/groups/public/") }
        maven { setUrl("https://maven.aliyun.com/nexus/content/repositories/jcenter") }
        google()
        mavenCentral()
        flatDir {
            dirs("libs")
        }
    }
}


tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}