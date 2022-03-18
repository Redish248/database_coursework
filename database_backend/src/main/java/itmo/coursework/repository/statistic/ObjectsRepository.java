package itmo.coursework.repository.statistic;

import itmo.coursework.entity.statistic.Objects;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObjectsRepository extends CrudRepository<Objects, Long> {
    Objects findObjectsByUid(long uid);

    List<Objects> findObjectsByName(String name);
}
