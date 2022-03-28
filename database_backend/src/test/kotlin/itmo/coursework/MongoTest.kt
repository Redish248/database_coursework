package itmo.coursework

import com.fasterxml.jackson.core.JsonProcessingException
import itmo.coursework.entity.animals.MongoAnimal
import itmo.coursework.entity.animals.Passport
import itmo.coursework.service.MongoAnimalService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

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
        animalService.createAnimal(animal)
    }

    @Test
    fun testDelete() {
        animalService.deleteAnimal(0)
    }
}