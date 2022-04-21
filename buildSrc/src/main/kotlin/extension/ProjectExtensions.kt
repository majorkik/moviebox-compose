package extension

import com.android.build.gradle.BaseExtension
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.get
import org.gradle.kotlin.dsl.getByType
import kotlin.coroutines.EmptyCoroutineContext.get

fun Project.android(action: BaseExtension.() -> Unit) = (extensions["android"] as BaseExtension).run(action)

inline val Project.catalogs
    get() = extensions.getByType<VersionCatalogsExtension>()

fun VersionCatalogsExtension.getVersion(name: String): String? = named("libs")
    .findVersion(name)
    .get()
    .requiredVersion
