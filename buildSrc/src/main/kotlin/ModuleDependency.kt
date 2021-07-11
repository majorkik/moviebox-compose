object ModuleDependency {

    const val app = ":app"

    object UI {
        const val main = ":ui:main"
    }

    object Core {
        const val ui = ":core:ui"
        const val network = ":core:network"
        const val base = ":core:base"
    }
}
