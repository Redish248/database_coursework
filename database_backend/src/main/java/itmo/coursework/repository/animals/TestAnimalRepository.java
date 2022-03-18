package itmo.coursework.repository.animals;

import itmo.coursework.entity.animals.TestAnimal;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface TestAnimalRepository extends MongoRepository<TestAnimal, Long> {

    @NotNull
    @Override
    List<TestAnimal> findAll();
}