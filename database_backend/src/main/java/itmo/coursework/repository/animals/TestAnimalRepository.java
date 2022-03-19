package itmo.coursework.repository.animals;

import itmo.coursework.entity.animals.TestAnimal;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Example;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.function.Function;

public interface TestAnimalRepository extends MongoRepository<TestAnimal, Long> {

    @NotNull
    List<TestAnimal> findAll();

}