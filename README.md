# MovieBox Compose

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.4.30-brightgreen)](https://kotlinlang.org)  [![AGP](https://img.shields.io/badge/AGP-7.0.0--alpha08-blue)](https://developer.android.com/studio/releases/gradle-plugin)  [![Gradle](https://img.shields.io/badge/Gradle-6.8.2-blue)](https://gradle.org)  [![Jetpack Compose](https://img.shields.io/badge/Jetpack%20Compose-1.0.0--beta01-blueviolet)](https://developer.android.com/jetpack/androidx/releases/compose) [![CodeFactor](https://www.codefactor.io/repository/github/majorkik/moviebox_compose/badge?s=26b8616958628d72ba4b9e711a532e0b28fa4f9e)](https://www.codefactor.io/repository/github/majorkik/moviebox_compose) [![codebeat badge](https://codebeat.co/badges/80853a65-81dc-46c1-8b63-7f4ee5c72bab)](https://codebeat.co/a/rodion/projects/github-com-majorkik-moviebox_compose-master)

#### Status 🚧 [Work in progress] 🚧

## Project characteristics and tech-stack

-   Tech-stack
    
    -   [100% Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - perform background operations
        
    -   Networking
        
        -   [Retrofit](https://square.github.io/retrofit/) - networking
            
        -   [OkHttp](https://github.com/square/okhttp) - http client
        
    -   [Jetpack Compose](https://developer.android.com/jetpack/compose)
        
    -   [Accompanist](https://github.com/chrisbanes/accompanist) - collection of extension libraries for Jetpack Compose
        
    -   [Coil](https://github.com/coil-kt/coil) - image loading library
        
    -   [Jetpack](https://developer.android.com/jetpack/)
        
        -   [Lifecycle](https://developer.android.com/topic/libraries/architecture/lifecycle) - perform an action when lifecycle state changes
            
        -   [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
        
    -   [Klock](https://github.com/korlibs/klock) - multiplatform Date and time library for Kotlin
    
-   Architecture
    
    -   MVVM + MVI (presentation layer)
        
    -   [Android Architecture components](https://developer.android.com/topic/libraries/architecture)
        
    -   [Android KTX](https://developer.android.com/kotlin/ktx) - Jetpack Kotlin extensions
    
-   Dependency Injection
    
    -   [Koin](https://github.com/InsertKoinIO/koin)
    
-   Static analysis tools
    
    -   [Ktlint](https://github.com/pinterest/ktlint) - validate code formatting
        
    -   [Detekt](https://github.com/arturbosch/detekt#with-gradle) - verify complexity look for and code smell
        
    -   [Spotless](https://github.com/diffplug/spotless) - keep your code spotless
    
-   Gradle
    
    -   [Gradle Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
        
    -   Custom tasks
    
-   Loggers
    
    -   [Timber](https://github.com/JakeWharton/timber)
        
    -   [Pretty Logger](https://github.com/orhanobut/logger) - simple, pretty and powerful logger for android

## Links

Here I will leave useful links to utilities, projects or articles that may come in handy when developing mobile applications.

#### Projects:

- [Jetpack compose samples](https://github.com/android/compose-samples) - official Jetpack Compose samples.

#### Useful links:

-   [Gradle plugins](https://plugins.gradle.org/plugin/com.diffplug.spotless) - Plugin search
    
-   [GitIgnore.io](https://www.toptal.com/developers/gitignore) - .gitignore builder
    

#### Useful articles:

-   [Make your Android code healthier: Static code analysis tools for Kotlin](https://www.rockandnull.com/static-code-analysis-android/)
    
-   [How to Write a Git Commit Message](https://chris.beams.io/posts/git-commit/)