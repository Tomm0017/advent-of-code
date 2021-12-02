plugins {
    kotlin("jvm")
}

allprojects {
    apply {
        plugin("org.jetbrains.kotlin.jvm")
    }

    repositories {
        mavenCentral()
    }

    dependencies {
        implementation(kotlin("stdlib-jdk8"))
        testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.1")
        testImplementation("org.junit.jupiter:junit-jupiter:5.7.1")
    }

    tasks.withType<JavaCompile> {
        options.release.set(11)
    }

    tasks {
        test {
            useJUnitPlatform()
        }
    }
}
