package itmo.coursework.repository.animals;

import itmo.coursework.entity.animals.MongoAnimal;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MongoAnimalRepository extends MongoRepository<MongoAnimal, Long> {

    MongoAnimal findMongoAnimalBy_id(int id);

    @NotNull
    List<MongoAnimal> findAll();

}
