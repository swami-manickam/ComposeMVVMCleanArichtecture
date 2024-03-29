# Compose-MVVM-CleanArch-Kotlin

CryptoCurrency android app to show the coins list and its details using Coinpaprika API.

### The following diagram shows the structure of this project with 3 layers:
1. UI
2. Domain
3. Data

- ui - It uses all the components and classes related to Android Framework. It gets the data from presentation layer and shows on UI. (access all the modules)
- data - The data layer implements the repository interface that the domain layer defines. This layer provide a single source of truth for data. (Kotlin module that can only access domain module)
- remote - Handles data interacting with the network. (can only access data module)
- cache - Handles data interacting with the local storing (Room DB). (can only access data module)
- domain - The domain layer contains the UseCases that encapsulate a single and very specific task that can be performed. This task is part of the business logic of the application. (Kotlin module that cannot access any other module)
- presentation - MVVM with ViewModels exposing LiveData that the UI consume. The ViewModel does not know anything about it's consumers. (Android module that can only access domain module)

### Technologies & Methodologies which used:
- MVVM with CleanArchitecture
- Android Architecture Components
- Compose - Jetpack Compose is Android’s recommended modern toolkit for building native UI.
- ViewModel - Stores UI-related data that isn't destroyed on UI changes.
- Room - Used to create room db and store the data.
- Navigation - Used to navigate between fragments.
- Coroutines - A coroutine is a concurrency design pattern that you can use on Android to simplify code that executes asynchronously
- Flow - Flow is used to pass (send) a stream of data that can be computed asynchronously
- Dependency Injection
  - Hilt - Easier way to incorporate Dagger DI into Android application.
  - Retrofit - A type-safe HTTP client for Android and Java.

![app_architecture.png](..%2F..%2F..%2F..%2FDesktop%2Fapp_architecture.png)
![architecture (1).png](..%2F..%2F..%2F..%2FDesktop%2Farchitecture%20%281%29.png)

### The app has the following base packages:
- app: Contains Application and AppConstant classes
- database: Models to work with Room database
- di: Hilt classes to work with Network and Database
- network: Services and network models
- repository: Contains all repositories
- usecase: to reduce the burden of ViewModel classes and reduce code duplication and complexity
- utils: Utility class
- presentation: View classes along with their corresponding ViewModel.


### Supported Android Versions

- Android Versions targeted: 34
- Android 7.0 Nougat(API level 24)


### Used libraries

1. [GitHub](http://square.github.io/retrofit/) - retrofit
2. [Gson](https://code.google.com/p/google-gson/) is another popular choice and being a smaller library than Jackson, you might prefer it to avoid 65k methods limitation. Also, if you are using  
