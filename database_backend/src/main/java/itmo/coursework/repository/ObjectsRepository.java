package itmo.coursework.repository;

import itmo.coursework.entity.Objects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectsRepository extends CrudRepository<Objects, Long> {
    Objects findObjectsByUid(long uid);

    List<Objects> findObjectsByName(String name);
}
