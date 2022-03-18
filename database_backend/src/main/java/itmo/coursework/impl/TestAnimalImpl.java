package itmo.coursework.impl;

import itmo.coursework.entity.animals.TestAnimal;
import itmo.coursework.repository.animals.TestAnimalRepository;
import itmo.coursework.service.TestAnimalService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TestAnimalImpl implements TestAnimalService {
    @Autowired
    private TestAnimalRepository testAnimalRepository;

    @Override
    public List<TestAnimal> findAll() {
        return testAnimalRepository.findAll();
    }
}
