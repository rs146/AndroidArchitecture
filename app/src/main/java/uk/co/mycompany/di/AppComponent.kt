package uk.co.mycompany.di

import dagger.Component
import uk.co.mycompany.ArchitectureApplication
import uk.co.mycompany.api.ApiService
import uk.co.mycompany.persistence.dao.PeopleDao
import uk.co.mycompany.repository.PeopleRepository
import uk.co.mycompany.repository.Repository
import uk.co.mycompany.util.SchedulerProvider
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {

    fun inject(architectureApplication: ArchitectureApplication)

    // expose to sub-graphs
    fun schedulerProvider(): SchedulerProvider

    fun apiService(): ApiService

    fun peopleDao(): PeopleDao

    fun repository(): Repository

    fun peopleRepository(): PeopleRepository
}