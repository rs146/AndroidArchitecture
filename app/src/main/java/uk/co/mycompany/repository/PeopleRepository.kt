package uk.co.mycompany.repository

import io.reactivex.Single
import uk.co.mycompany.model.Person
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PeopleRepository @Inject constructor() {

    fun retrievePerson(): Single<Person> {
        val person = Person("Rahul", "Singh", 10, 5)
        return Single.just(person)
    }
}