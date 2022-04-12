# MovieBox Compose [ [Backend](https://github.com/majorkik/moviebox-backend) ]

[![Android Studio Arctic Fox](https://img.shields.io/badge/AS%20Dolphin-Canary%209-9cf)](https://developer.android.com/studio/preview) [![Kotlin Version](https://img.shields.io/badge/Kotlin-1.6.10-brightgreen)](https://kotlinlang.org)  [![AGP](https://img.shields.io/badge/AGP-7.1.2-blue)](https://developer.android.com/studio/releases/gradle-plugin)  [![Gradle](https://img.shields.io/badge/Gradle-7.4.2-blue)](https://gradle.org)  [![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.2.0--alpha06-blueviolet)](https://developer.android.com/jetpack/androidx/releases/compose) [![CodeFactor](https://www.codefactor.io/repository/github/majorkik/moviebox-compose/badge)](https://www.codefactor.io/repository/github/majorkik/moviebox-compose) [![codebeat badge](https://codebeat.co/badges/80853a65-81dc-46c1-8b63-7f4ee5c72bab)](https://codebeat.co/a/rodion/projects/github-com-majorkik-moviebox_compose-master)

#### Status 🚧 [Work in progress] 🚧

## Project characteristics and tech-stack

### Tech-stack

- [100% Kotlin](https://kotlinlang.org/)
  + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform
  background operations
- **Networking**: [Retrofit](https://square.github.io/retrofit/)
  + [OkHttp](https://github.com/square/okhttp)
- [Jetpack Compose](https://developer.android.com/jetpack/compose)
- [Accompanist](https://github.com/chrisbanes/accompanist) - collection of extension libraries for
  Jetpack Compose
- [Coil](https://github.com/coil-kt/coil) - image loading library
- [Jetpack](https://developer.android.com/jetpack/)
    - [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an
      action when lifecycle state changes
    - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and
      manage UI-related data in a lifecycle conscious way
- [Klock](https://github.com/korlibs/klock) - multiplatform Date and time library for Kotlin
- Architecture
    - MVVM + MVI (presentation layer)
    - [Android Architecture components](https://developer.android.com/topic/libraries/architecture)
    - [Android KTX](https://developer.android.com/kotlin/ktx) - Jetpack Kotlin extensions
- **Dependency Injection**: [Koin](https://github.com/InsertKoinIO/koin)
- Static analysis tools
    - [Ktlint](https://github.com/pinterest/ktlint) - validate code formatting
    - [Detekt](https://github.com/arturbosch/detekt#with-gradle) - verify complexity look for and
      code smell
    - [Spotless](https://github.com/diffplug/spotless) - keep your code spotless
- **Gradle**: [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html) +
  Custom tasks
- **Loggers**: [Kotlin Logging](https://github.com/MicroUtils/kotlin-logging)
- **Dependency versions**: [Version catalog TOML file format](https://docs.gradle.org/current/userguide/platforms.html)

## Architecture

### Multi-module architecture

![Multi-module architecture](docs/image/multimodule-arch-future-core-modules.svg?raw=true)

- **App module**: the entry point to the application, contains almost no code, depends on the
  feature-modules.
- **Feature module**: contain specific functionality. By structure, these modules can contain all
  the layers of your architecture, but they can also just contain some feature without any layers. A
  feature module can have dependencies on other feature modules **only** through an API module or on
  the main module, if we are talking about an feature UI module. Feature modules can be divided into
  three types:
    - **Feature UI module**: contains a screen, a group of screens, views, resources, and other code
      to implement a specific UI. Feature UI modules are independent of other feature UI modules.
      For interconnection between feature UI modules, a helper module is usually used that contains
      specific code for their interaction (for example, a module that contains code for navigating
      between screens).
    - **Feature module of implementation**: contains implementations of interfaces from the API
      module, contains classes for working with the database and server, data models with JSON
      annotations for *serializing/deserializing* data. It resembles a **data layer** from a Clean
      architecture;
    - **Feature API module**: contains interfaces for working with data, data models without JSON
      annotations, business logic and usecases.
- **Core module**: contains helper code that can be used in more than one module. These can be
  abstract classes, utilities, providing libraries through transitive dependencies, and so on. Core
  modules do not depend on any other modules.
- **BuildSrc**: can contain application configuration, dependency versions and custom gradle tasks.

### Future modules

![Future modules](docs/image/future-modules.svg?raw=true)

## Getting started

There are a few ways to open this project.

### Android Studio

1. `Android Studio` -> `File` -> `New` -> `From Version control` -> `Git`
2. Enter `https://github.com/majorkik/MovieBox-Compose.git` into URL field an press `Clone` button

### Command-line + Android Studio

1. Run `git clone https://github.com/majorkik/MovieBox-Compose.git` command to clone project
2. Open `Android Studio` and select `File | Open...` from the menu. Select cloned directory and
   press `Open` button

### Project configuration

Add parameters in the locale.properties file as shown in the example below.

```bash
keyTmdb="Your TMDb Key"
```

#### Where can I get a TMDb API key?

1. Open [TheMovieDatabase](https://www.themoviedb.org/) -> `Login/Join TMDb` -> `Profile`
   -> `Settings` -> `API` -> Copy `API Key (v3 auth)`
2. Paste copied key into `local.properties` file (`keyTmdb`)

## Links

Here I will leave useful links to utilities, projects or articles that may come in handy when
developing mobile applications.

#### Projects:

- [Jetpack compose samples](https://github.com/android/compose-samples) - official Jetpack Compose
  samples.

## Issues

- [ ] Prior to Gradle 7.4.2, you have to write `@Suppress("DSL_SCOPE_VIOLATION")` when using `alias(libs.plugins...)` in the `plugins { }` block

#### Useful links:

- [Gradle plugins](https://plugins.gradle.org/plugin/com.diffplug.spotless) - Plugin search
- [GitIgnore.io](https://www.toptal.com/developers/gitignore) - .gitignore builder

#### Useful articles:

- [Make your Android code healthier: Static code analysis tools for Kotlin](https://www.rockandnull.com/static-code-analysis-android/)
- [How to Write a Git Commit Message](https://chris.beams.io/posts/git-commit/)
