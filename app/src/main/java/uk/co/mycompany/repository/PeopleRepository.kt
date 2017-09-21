package uk.co.mycompany.repository

import io.reactivex.Flowable
import io.reactivex.Single
import uk.co.mycompany.persistence.dao.PeopleDao
import uk.co.mycompany.persistence.entity.Person
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PeopleRepository @Inject constructor(private val peopleDao: PeopleDao) {

    fun insertPerson(): Single<Person> {
        val person = Person("1", "Rahul", "Singh", 10, 5)
        peopleDao.savePerson(person)
        return Single.just(person)
    }

    fun getPeople(): Flowable<List<Person>> = peopleDao.findAllPeople()
}