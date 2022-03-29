package itmo.coursework.impl;

import itmo.coursework.entity.animals.MongoAnimal;
import itmo.coursework.exception.AnimalNotFoundException;
import itmo.coursework.model.AddAnimalRequest;
import itmo.coursework.repository.animals.MongoAnimalRepository;
import itmo.coursework.service.MongoAnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class MongoAnimalImpl implements MongoAnimalService {
    private final MongoAnimalRepository mongoAnimalRepository;

    @Override
    public List<MongoAnimal> findAllAnimals() {
        return mongoAnimalRepository.findAll();
    }

    @Override
    public MongoAnimal createAnimal(AddAnimalRequest newAnimal) {
        MongoAnimal animal = new MongoAnimal();
        animal.setId(UUID.randomUUID().toString());
        animal.setAnimalType(newAnimal.getAnimalType());
        animal.setGender(newAnimal.getGender());
        animal.setWeight(newAnimal.getWeight());
        animal.setAge(newAnimal.getAge());
        animal.setDateOfArrival(newAnimal.getDateOfArrival());
        animal.setPlaceOfArrival(newAnimal.getPlaceOfArrival());
        animal.setPhoto(newAnimal.getPhoto());
        animal.setEyesColor(newAnimal.getEyesColor());
        animal.setFurColor(newAnimal.getFurColor());
        animal.setPassport(newAnimal.getPassport());
        animal.setNewOwner(newAnimal.getNewOwner());
        animal.setFeed(newAnimal.getFeed());
        animal.setAnimalTypeInfo(newAnimal.getAnimalTypeInfo());
        animal.setAdditionalCharacteristics(newAnimal.getAdditionalCharacteristics());

        return createAnimal(animal);
    }

    private MongoAnimal createAnimal(MongoAnimal animal) {
        return mongoAnimalRepository.save(animal);
    }

    @Override
    public MongoAnimal updateAnimal(MongoAnimal animal) {
        // fixme - по хорошему сюда надо UpdateAnimalRequest с nullable полями , но я на java это буду делать долго и мучительно (
        if (mongoAnimalRepository.existsById(animal.getId()))
            return mongoAnimalRepository.save(animal);
        else throw new AnimalNotFoundException(animal.getId());
    }

    @Override
    public void deleteAnimal(String miuid) {
        mongoAnimalRepository.deleteById(miuid);
    }
}
