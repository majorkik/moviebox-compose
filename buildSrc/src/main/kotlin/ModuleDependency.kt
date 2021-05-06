import kotlin.reflect.full.memberProperties

object ModuleDependency {

    const val app = ":app"

    const val featureCollections = ":feature_collections"
    const val featureDetails = ":feature_details"
    const val featureDiscover = ":feature_discover"
    const val featureNavigation = ":feature_navigation"

    const val featureMovieApi = ":feature_movie_api"
    const val featureMovieImpl = ":feature_movie_impl"

    const val featureTVApi = ":feature_tv_api"
    const val featureTVImpl = ":feature_tv_impl"

    const val featureCastApi = ":feature_cast_api"
    const val featureCastImpl = ":feature_cast_impl"

    const val featureDiscoverApi = ":feature_discover_api"
    const val featureDiscoverImpl = ":feature_discover_impl"


    const val coreUi = ":core_ui"
    const val coreNetwork = ":core_network"
    const val coreBase = ":core_base"

    fun getAllFeatureModules() = ModuleDependency::class.memberProperties
        .filter { it.isConst }
        .filter { it.getter.call().toString().contains("feature") }
        .map { it.getter.call().toString() }
}
