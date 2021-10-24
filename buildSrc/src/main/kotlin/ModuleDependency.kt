object ModuleDependency {

    const val app = ":app"
    const val navigation = ":navigation"

    object UI {
        private const val directory = ":ui"

        const val main = "$directory:main"
        const val home = "$directory:home"
    }

    object Core {
        private const val directory = ":core"

        const val ui = "$directory:ui"
    }
}
