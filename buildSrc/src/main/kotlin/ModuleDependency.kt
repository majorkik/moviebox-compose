object ModuleDependency {

    const val app = ":app"

    object UI {
        const val main = ":ui:main"
        const val home = ":ui:home"
    }

    object Core {
        const val ui = ":core:ui"
        const val network = ":core:network"
        const val base = ":core:base"
    }
}
