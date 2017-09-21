package uk.co.mycompany.persistence.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey
import java.util.*

@Entity(tableName = "Person")
data class Person(@PrimaryKey
                  @ColumnInfo(name = "personId")
                  val id: String = UUID.randomUUID().toString(),
                  val firstName: String, val surname: String, val age: Int, val numberOfHobbies: Int)