package itmo.coursework.model

import itmo.coursework.entity.animals.*
import java.sql.Date

data class AddAnimalRequest(
    val name: String,
    val animalType: String,
    val gender: String,
    val weight: Int = 0,
    val age: Int,
    val dateOfArrival: String,
    val placeOfArrival: String,
    val photo: String,
    val furColor: String,
    val eyesColor: String,
    val passport: Passport,
    val newOwner: Owner,
    val feed: List<Feed>,
    val animalTypeInfo: AnimalTypeInfo,
    var additionalCharacteristics: MutableList<Characteristic?>
)


data class UpdateAnimalRequest(
    val uid: String,
    val name: String? = null,
    val animalType: String? = null,
    val gender: String? = null,
    val weight: Int? = null,
    val age: Int? = null,
    val dateOfArrival: Date? = null,
    val placeOfArrival: String? = null,
    val photo: String? = null,
    val furColor: String? = null,
    val eyesColor: String? = null,
    val passport: Passport? = null,
    val newOwner: Owner? = null,
    val previousOwner: Owner? = null,
    val feed: List<Feed>? = null,
    val animalTypeInfo: AnimalTypeInfo? = null,
    var additionalCharacteristics: MutableList<Characteristic?>? = null
)