package itmo.coursework.controller;

import itmo.coursework.entity.animals.MongoAnimal;
import itmo.coursework.model.AddAnimalRequest;
import itmo.coursework.service.MongoAnimalService;
import itmo.coursework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/databases/mongo/animals")
@RequiredArgsConstructor
public class MongoAnimalController {
    private final MongoAnimalService mongoAnimalService;
    private final UserService userService;

    @GetMapping("/getAllMongoAnimals")
    public @ResponseBody
    ResponseEntity getAllMongoAnimal() {
        List<MongoAnimal> mongoAnimals = mongoAnimalService.findAllAnimals();
        return ResponseEntity.status(HttpStatus.OK).body(mongoAnimals);
    }

    @PostMapping("/createMongoAnimal")
    public @ResponseBody
    ResponseEntity createMongoAnimal(@RequestBody AddAnimalRequest newAnimal) {
        MongoAnimal animal = mongoAnimalService.createAnimal(newAnimal);
        return ResponseEntity.status(HttpStatus.CREATED).body(animal);
    }

    @PostMapping("/updateMongoAnimal")
    public @ResponseBody
    ResponseEntity updateMongoAnimal(@RequestBody MongoAnimal animal) {
        MongoAnimal newAnimal = mongoAnimalService.updateAnimal(animal);
        return ResponseEntity.status(HttpStatus.OK).body(newAnimal);
    }

    @DeleteMapping("/deleteMongoAnimal/{uid}")
    public @ResponseBody
    ResponseEntity deleteMongoAnimal(@PathVariable String uid) {
        mongoAnimalService.deleteAnimal(uid);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @GetMapping("/getSystemUsers")
    public @ResponseBody
    ResponseEntity getUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(
                userService.getUsers()
        );
    }

}
