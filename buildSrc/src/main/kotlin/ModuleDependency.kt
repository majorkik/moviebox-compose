import kotlin.reflect.full.memberProperties

object ModuleDependency {

    const val app = ":app"

    const val featureCollections = ":feature_collections"
    const val featureDetails = ":feature_details"
    const val featureDiscover = ":feature_discover"
    const val featureNavigation = ":feature_navigation"

    const val coreUi = ":core_ui"
    const val coreNetwork = ":core_ui"

    fun getAllFeatureModules() = ModuleDependency::class.memberProperties
        .filter { it.isConst }
        .filter { it.getter.call().toString().contains("feature") }
        .map { it.getter.call().toString() }
}
