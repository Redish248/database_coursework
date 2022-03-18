package itmo.coursework.service;

import itmo.coursework.entity.animals.TestAnimal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TestAnimalService {
    List<TestAnimal> findAll();
}
