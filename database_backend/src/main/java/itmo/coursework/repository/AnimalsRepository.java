package itmo.coursework.repository;

import itmo.coursework.entity.Animals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalsRepository extends CrudRepository<Animals, Long> {
    Animals findAnimalsByUid(long uid);

    Animals findAnimalsByName(String name);

    List<Animals> findAnimalsByAmountGreaterThan(int amount);

    List<Animals> findAnimalsByAmountLessThan(int amount);
}
