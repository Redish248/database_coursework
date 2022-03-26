package itmo.coursework

import itmo.coursework.service.TestAnimalService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MongoTest {

    @Autowired
    private lateinit var animalService: TestAnimalService

    @Test
    fun `mongo alive`() {
        val animals = animalService.findAll()
        println(animals)
        Assertions.assertTrue { animals.size > 0 }
    }
}