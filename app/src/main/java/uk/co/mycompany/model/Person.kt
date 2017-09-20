package uk.co.mycompany.model

import uk.co.mycompany.api.model.IpAddress

data class Person(val firstName: String, val surname: String, val age: Int, val numberOfHobbies: Int)

data class MainDataHolder(val person: Person, val ipAddress: IpAddress)