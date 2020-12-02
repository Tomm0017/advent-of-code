plugins {
    kotlin("jvm") version "1.4.20"
}

repositories {
    mavenCentral()
}

apply {
    plugin("org.jetbrains.kotlin.jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
