package itmo.coursework

import itmo.coursework.service.AnimalService
import org.springframework.stereotype.Service

@Service
class TestService(private val animalService: AnimalService) {

    fun testFun() {
        println("it's oK")
    }
}