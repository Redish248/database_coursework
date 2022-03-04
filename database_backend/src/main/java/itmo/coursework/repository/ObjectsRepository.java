package itmo.coursework.repository;

import itmo.coursework.entity.Objects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectsRepository extends CrudRepository<Objects, Integer> {
}
