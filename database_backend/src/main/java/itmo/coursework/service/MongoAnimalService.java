package itmo.coursework.service;

import itmo.coursework.entity.animals.MongoAnimal;

import java.util.List;

public interface MongoAnimalService {
    List<MongoAnimal> findAllAnimals();

    MongoAnimal createAnimal(MongoAnimal animal);

    MongoAnimal updateAnimal(MongoAnimal animal);

    void deleteAnimal(int miuid);
}
