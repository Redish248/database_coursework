package itmo.coursework.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import itmo.coursework.entity.animals.MongoAnimal;

import java.util.List;

public interface MongoAnimalService {
    List<MongoAnimal> findAll();

    void createAnimal(MongoAnimal animal) throws JsonProcessingException;

    void updateAnimal(MongoAnimal animal);

    void deleteAnimal(int miuid);
}
