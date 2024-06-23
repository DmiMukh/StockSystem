object Libs {
    object Coroutines {
        private const val version = "1.7.2"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$version"
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$version"
    }

    object Decompose {

        private const val version = "2.0.0"

        const val core = "com.arkivanov.decompose:decompose:$version"
        const val compose = "com.arkivanov.decompose:extensions-compose-jetpack:$version"
        const val android = "com.arkivanov.decompose:extensions-android:$version"

    }

    object Koin {

        private const val version = "3.4.0"

        const val core = "io.insert-koin:koin-android:$version"
        const val android = "io.insert-koin:koin-android:$version"
        const val compose = "io.insert-koin:koin-androidx-compose:$version"
    }

    object KotlinX {

        object Datetime {
            private const val version = "0.4.0"
            const val core = "org.jetbrains.kotlinx:kotlinx-datetime:$version"
        }

        object Serialization {

            val plugin = "plugin.serialization"
            val pluginVersion = "1.8.10"

            private val version = "1.5.1"

            val contentNegotation = "io.ktor:ktor-client-content-negotiation:$version"
            val json = "org.jetbrains.kotlinx:kotlinx-serialization-json:$version"
        }
    }

    object Ktor {
        private val version = "2.3.3"

        val core = "io.ktor:ktor-client-core:$version"
        val android = "io.ktor:ktor-client-android:$version"
        val serialization = "io.ktor:ktor-serialization-kotlinx-json:$version"
        val logging = "io.ktor:ktor-client-logging:$version"
        val negotiation = "io.ktor:ktor-client-content-negotiation:$version"
    }

    /*
    object Paging {
        private const val version = "3.1.1"

        const val core = "androidx.paging:paging-runtime:$version"

        // optional - Jetpack Compose integration
        const val compose = "androidx.paging:paging-compose:1.0.0-alpha18"
    }

    object SQLDelight {

        const val version = "2.0.0"

        const val android = "app.cash.sqldelight:android-driver:$version"

        const val plugin = "app.cash.sqldelight"

        const val coroutines = "app.cash.sqldelight:coroutines-extensions:$version"

        const val paging = "app.cash.sqldelight:androidx-paging3-extensions:$version"
    }
    */
}