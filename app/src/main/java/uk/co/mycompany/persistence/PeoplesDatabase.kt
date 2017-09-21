package uk.co.mycompany.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import uk.co.mycompany.persistence.dao.PeopleDao
import uk.co.mycompany.persistence.entity.Person

@Database(entities = arrayOf(Person::class), version = 1)
abstract class PeoplesDatabase : RoomDatabase() {

    abstract fun peopleDao(): PeopleDao
}