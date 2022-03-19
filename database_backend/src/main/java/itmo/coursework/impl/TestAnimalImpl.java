package itmo.coursework.impl;

import itmo.coursework.entity.animals.TestAnimal;
import itmo.coursework.repository.animals.TestAnimalRepository;
import itmo.coursework.service.TestAnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestAnimalImpl implements TestAnimalService {
    private final TestAnimalRepository testAnimalRepository;

    @Override
    public List<TestAnimal> findAll() {
        return testAnimalRepository.findAll();
    }

    @Override
    public List<TestAnimal> findByName(String name) {
        return null;
    }
}
