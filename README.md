# AndroidArchitecture

A simple project showing a base architecture for MVVM using Dagger 2, RxJava 2, Retrofit and some of the newer Android Architecture Components.

Layers of the app:
 * API - contains the api related classes included Reponse models.
 * DI - contains all the Dagger 2 injection classes.
 * Model - contains the model/business model that will be presented to the view.
 * Repository - interacts with various datasources (api, database etc.) and performs processing of that data.
 * ViewModel - interacts with Repositories. It also gives data to the view where the view can subscribe to that data.
 * UI - the actual Android UI components.
 