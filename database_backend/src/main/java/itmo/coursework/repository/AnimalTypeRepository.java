package itmo.coursework.repository;

import itmo.coursework.entity.AnimalType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalTypeRepository extends CrudRepository<AnimalType, Long> {
    AnimalType findAnimalTypeByUid(long uid);

    AnimalType findAnimalTypeByName(String name);
}
