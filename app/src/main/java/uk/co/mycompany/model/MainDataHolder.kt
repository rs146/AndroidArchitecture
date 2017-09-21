package uk.co.mycompany.model

import uk.co.mycompany.api.model.IpAddress
import uk.co.mycompany.persistence.entity.Person

data class MainDataHolder(val person: Person, val ipAddress: IpAddress)