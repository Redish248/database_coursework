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
    public List<MongoAnimal> findAll() {
        return mongoAnimalRepository.findAll();
    }

    @Override
    public void createAnimal(MongoAnimal animal) {
        mongoAnimalRepository.save(animal);
    }

    @Override
    public void updateAnimal(MongoAnimal animal) {

    }

    @Override
    public void deleteAnimal(int miuid) {
       /* MongoAnimal animal = mongoAnimalRepository.findMongoAnimalByMuid(miuid);
        mongoAnimalRepository.delete(animal);*/
    }
}
