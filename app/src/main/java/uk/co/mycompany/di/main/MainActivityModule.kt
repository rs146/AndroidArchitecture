package uk.co.mycompany.di.main

import dagger.Module
import dagger.Provides
import uk.co.mycompany.di.scope.MainActivityScope
import uk.co.mycompany.repository.PeopleRepository
import uk.co.mycompany.repository.Repository
import uk.co.mycompany.ui.MainActivity
import uk.co.mycompany.util.SchedulerProvider
import uk.co.mycompany.viewmodels.MainViewModel

@Module
class MainActivityModule(val mainActivity: MainActivity) {

    @Provides
    @MainActivityScope
    fun provideMainActivity() = mainActivity

    @Provides
    @MainActivityScope
    fun provideMainViewModel(repository: Repository, peopleRepository: PeopleRepository,
                             schedulerProvider: SchedulerProvider) = MainViewModel(repository, peopleRepository, schedulerProvider)
}