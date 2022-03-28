package itmo.coursework.service;

import itmo.coursework.entity.animals.MongoAnimal;
import itmo.coursework.model.AddAnimalRequest;

import java.util.List;

public interface MongoAnimalService {
    List<MongoAnimal> findAllAnimals();

    MongoAnimal createAnimal(AddAnimalRequest animal);

    MongoAnimal updateAnimal(MongoAnimal animal);

    void deleteAnimal(String miuid);
}
