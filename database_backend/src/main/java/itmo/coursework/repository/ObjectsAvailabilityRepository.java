package itmo.coursework.repository;

import itmo.coursework.entity.Objects;
import itmo.coursework.entity.ObjectsAvailability;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectsAvailabilityRepository extends CrudRepository<ObjectsAvailability, Long> {
    ObjectsAvailability findObjectsAvailabilityByUid(long uid);

    List<ObjectsAvailability> findObjectsAvailabilitiesByObjectType(Objects objectType);

    List<ObjectsAvailability> findObjectsAvailabilitiesByAmountGreaterThan(int amount);

    List<ObjectsAvailability> findObjectsAvailabilitiesByAmountLessThan(int amount);
}
