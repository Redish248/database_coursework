package itmo.coursework

import com.fasterxml.jackson.core.JsonProcessingException
import itmo.coursework.entity.animals.*
import itmo.coursework.model.AddAnimalRequest
import itmo.coursework.service.MongoAnimalService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.sql.Date

@SpringBootTest
class MongoTest {

    @Autowired
    private lateinit var animalService: MongoAnimalService

    @Test
    fun `mongo alive`() {
        val animals = animalService.findAllAnimals()
        println(animals)
        Assertions.assertTrue { animals.size > 0 }
    }

    @Test
    @Throws(JsonProcessingException::class)
    fun testSave() {
        val passport = Passport()
        passport.number = "1"
        passport.officialName = "of name"
        val animal = AddAnimalRequest(
            name = "Vasya",
            age = 11,
            eyesColor = "green",
            passport = passport,
            weight = 10,
            animalType = "cat",
            gender = "m",
            dateOfArrival = Date.valueOf("2022.10.02"),
            placeOfArrival = "",
            photo = byteArrayOf(),
            furColor = "",
            newOwner = Owner(),
            feed = emptyList(),
            animalTypeInfo = AnimalTypeInfo(),
            additionalCharacteristics = emptyList<Characteristic?>() as MutableList<Characteristic?>
        )
        animalService.createAnimal(animal)
    }

    @Test
    fun testDelete() {
        // attention - diff uid every time
        animalService.deleteAnimal("21c2c4e7-8e84-4d80-8d29-047916a79405")
    }
}