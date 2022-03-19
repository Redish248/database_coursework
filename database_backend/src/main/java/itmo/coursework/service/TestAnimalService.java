package itmo.coursework.service;

import itmo.coursework.entity.animals.TestAnimal;

import java.util.List;

public interface TestAnimalService {
    List<TestAnimal> findAll();

    List<TestAnimal> findByName(String name);
}
