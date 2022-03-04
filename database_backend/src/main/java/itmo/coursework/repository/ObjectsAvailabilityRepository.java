package itmo.coursework.repository;

import itmo.coursework.entity.ObjectsAvailability;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectsAvailabilityRepository extends CrudRepository<ObjectsAvailability, Integer> {
}
