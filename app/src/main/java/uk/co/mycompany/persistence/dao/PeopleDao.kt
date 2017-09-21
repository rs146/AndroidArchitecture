package uk.co.mycompany.persistence.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import uk.co.mycompany.persistence.entity.Person

@Dao
interface PeopleDao {

    @Query("SELECT * FROM Person")
    fun findAllPeople(): Flowable<List<Person>>

    @Insert
    fun savePerson(person: Person)
}