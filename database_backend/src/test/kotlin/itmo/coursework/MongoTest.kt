package itmo.coursework

import com.fasterxml.jackson.core.JsonProcessingException
import itmo.coursework.entity.animals.MongoAnimal
import itmo.coursework.entity.animals.Passport
import itmo.coursework.service.MongoAnimalService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import java.util.*

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
        val animal = MongoAnimal()
        animal.name = "Vasya"
        animal.age = 11
        animal.eyesColor = "green"
        animal.passport = passport
        animal.id = UUID.randomUUID().toString()
        animalService.createAnimal(animal)
    }

    @Test
    fun testDelete() {
        // attention - diff uid every time
        animalService.deleteAnimal("21c2c4e7-8e84-4d80-8d29-047916a79405")
    }
}