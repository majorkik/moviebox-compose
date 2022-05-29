package com.majorkik.movieboxcompose

import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.getByType

inline val Project.catalogs
    get() = extensions.getByType<VersionCatalogsExtension>()

fun VersionCatalogsExtension.getVersion(name: String): String? = named("libs")
    .findVersion(name)
    .get()
    .requiredVersion
