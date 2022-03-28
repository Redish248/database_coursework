package itmo.coursework.impl;

import itmo.coursework.entity.animals.MongoAnimal;
import itmo.coursework.repository.animals.MongoAnimalRepository;
import itmo.coursework.service.MongoAnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MongoAnimalImpl implements MongoAnimalService {
    private final MongoAnimalRepository mongoAnimalRepository;

    @Override
    public List<MongoAnimal> findAllAnimals() {
        return mongoAnimalRepository.findAll();
    }

    @Override
    public MongoAnimal createAnimal(MongoAnimal animal) {
        return mongoAnimalRepository.save(animal);
    }

    @Override
    public MongoAnimal updateAnimal(MongoAnimal animal) {
        return null;
    }

    @Override
    public void deleteAnimal(int miuid) {
       /* MongoAnimal animal = mongoAnimalRepository.findMongoAnimalByMuid(miuid);
        mongoAnimalRepository.delete(animal);*/
    }
}
