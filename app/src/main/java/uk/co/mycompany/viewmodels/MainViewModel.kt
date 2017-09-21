package uk.co.mycompany.viewmodels

import io.reactivex.Flowable
import io.reactivex.Single
import uk.co.mycompany.model.MainDataHolder
import uk.co.mycompany.persistence.entity.Person
import uk.co.mycompany.repository.PeopleRepository
import uk.co.mycompany.repository.Repository
import uk.co.mycompany.util.SchedulerProvider

class MainViewModel(private val repository: Repository, private val peopleRepository: PeopleRepository, private val schedulerProvider: SchedulerProvider) {

    fun showDataFromApiAndUser(): Single<MainDataHolder> {
        return repository.getDataFromApi()
                .flatMap { ipAddress -> peopleRepository.insertPerson()
                        .flatMap { person -> Single.just(MainDataHolder(person, ipAddress)) }}
                .compose(schedulerProvider.getSchedulersForSingle())
    }

    fun showPeopleFromDb(): Flowable<List<Person>> =
            peopleRepository.getPeople()
                    .compose(schedulerProvider.getSchedulersForFlowable())
}