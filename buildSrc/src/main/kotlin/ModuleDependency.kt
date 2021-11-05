object ModuleDependency {

    const val app = ":app"
    const val navigation = ":navigation"

    object UI {
        private const val directory = ":ui"

        const val main = "$directory:main"
        const val home = "$directory:home"
        const val movieDetails = "$directory:movie_details"
    }

    object Feature {
        private const val directory = ":feature"

        const val tmdbApi = "$directory:tmdb_api"
        const val tmdbImpl = "$directory:tmdb_impl"
    }

    object Core {
        private const val directory = ":core"

        const val ui = "$directory:ui"
    }
}
