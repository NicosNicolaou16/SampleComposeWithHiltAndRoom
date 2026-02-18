# Sample Compose With Hilt and Room

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Site](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Google Developer Profile](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

A sample Android project that demonstrates a modern, scalable architecture using the latest technologies recommended by Google. This application integrates Jetpack Compose for the UI, Hilt for dependency injection, and Room for local database management, providing a solid foundation for building robust apps.

## ✨ Features

*   **Modern UI:** Built entirely with **Jetpack Compose**, Google's modern toolkit for building native Android UI.
*   **Offline Support:** Caches data retrieved from the remote server using **Room Database**, enabling full offline functionality.
*   **Efficient Networking:** Fetches data from the [SpaceX-API](https://github.com/r-spacex/SpaceX-API) using **Retrofit**.
*   **Optimized Performance:** Leverages **Coroutines** for asynchronous operations, **KSP** for faster annotation processing, and **R8** for code shrinking and optimization.
*   **Scalable Architecture:** Follows the **MVVM (Model-View-ViewModel)** pattern with a repository, ensuring a clean separation of concerns and a maintainable codebase.
*   **Modern Navigation:** Utilizes **Navigation 3** for Jetpack Compose, offering a declarative and robust way to manage app navigation.
*   **Dependency Injection:** Implements **Hilt** to simplify dependency management and improve modularity.

## 🛠️ Tech Stack & Libraries

This project is built with **[Kotlin](https://kotlinlang.org/docs/getting-started.html)** and utilizes a variety of modern Android libraries and tools:

-   **UI:** [Jetpack Compose](https://developer.android.com/develop/ui/compose)
-   **Architecture:** [MVVM](https://developer.android.com/topic/architecture#recommended-app-arch) with Repository Pattern
-   **Asynchronicity:** [Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html), [Kotlin KTX](https://developer.android.com/kotlin/ktx)
-   **Navigation:** [Navigation Compose 3](https://developer.android.com/guide/navigation/navigation-3)
-   **Data:** [Retrofit](https://square.github.io/retrofit/) (Networking), [Room](https://developer.android.com/training/data-storage/room) (Database)
-   **Dependency Injection:** [Hilt](https://dagger.dev/hilt/)
-   **Build & Optimization:** [KSP](https://developer.android.com/build/migrate-to-ksp), [R8](https://developer.android.com/build/shrink-code)

## 🔧 Versioning

-   **Target SDK:** *36*
-   **Minimum SDK:** *29*
-   **Kotlin Version:** *2.3.0*
-   **Gradle Version:** *8.13.2*

## 📚 APIs & References

-   **Data Source:** [SpaceX-API on GitHub](https://github.com/r-spacex/SpaceX-API)
-   **API Documentation:** [SpaceX-API Docs (Postman)](https://docs.spacexdata.com/?version=latest)



# Sample Compose With Hilt and Room

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Static Badge](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Static Badge](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

This project is an application that utilizes the latest and recommended Google technologies for
Android, including Jetpack Compose, Hilt for dependency injection, and Room for database management.

# The Project Contain the following technologies

The programming language is the [Kotlin](https://kotlinlang.org/docs/getting-started.html), it is a
modern, JVM-based programming language that is concise, safe, and interoperable with Java. <br />
[Kotlin Coroutines](https://kotlinlang.org/docs/coroutines-overview.html) is used for asynchronous
tasks. <br />
[Kotlin KTX](https://developer.android.com/kotlin/ktx) is a collection of Kotlin extensions that
offer more concise and expressive code for working with Android APIs and libraries.
The UI is build using [Jetpack Compose](https://developer.android.com/develop/ui/compose). <br />
[Retrofit](https://square.github.io/retrofit/) is responsible for making requests and retrieving
data from the remote server. ([Repository](https://github.com/square/retrofit)) <br />
[Hilt Dependencies Injection](https://developer.android.com/training/dependency-injection/hilt-android)
is an Android library that simplifies dependency injection by using annotations to automatically
manage and provide dependencies across components, built on top of
Dagger. ([Documentation](https://dagger.dev/hilt/)) <br />
[Room Database](https://developer.android.com/training/data-storage/room) is responsible for saving
the retrieved data from the remote server, querying data from the local database, and supporting
offline functionality.  <br />
[MVVM](https://developer.android.com/topic/architecture#recommended-app-arch) with repository is an
architecture where the Repository manages data sources (e.g., network, database), the ViewModel
processes the data for the UI, and the View displays the UI, ensuring a clear separation of
concerns. <br />
[KSP](https://developer.android.com/build/migrate-to-ksp) ("Kotlin Symbol Processing") is a tool for
efficient annotation processing in Kotlin, providing faster code generation and symbol manipulation
compared to KAPT. [Repository](https://github.com/google/ksp) <br />
[Navigation 3](https://developer.android.com/guide/navigation/navigation-3) for Jetpack Compose is a
modern, Compose-native navigation system where you manage a
stack of serializable destination keys and display them with NavDisplay, giving you direct control,
state retention, and flexible adaptive UI without traditional graphs or routes. <br />
[R8](https://developer.android.com/build/shrink-code) enabled, is a code shrinker and obfuscator for
Android that optimizes and reduces the size of APKs by removing unused code and resources, while
also obfuscating the remaining code to improve security. <br />

# Versioning

Target SDK version: 36 <br />
Minimum SDK version: 29 <br />
Kotlin version: 2.3.0 <br />
Gradle version: 8.13.2 <br />

# Feeds/Urls/End Point (parsing some data from the response)

## (Links References for Ends Points)

- https://github.com/r-spacex/SpaceX-API (GitHub) <br />
- https://docs.spacexdata.com/?version=latest (Postman) <br />