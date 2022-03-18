package itmo.coursework.repository.statistic;

import itmo.coursework.entity.statistic.Position;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {
    Position findPositionByUid(long uid);

    List<Position> findPositionByName(String name);
}
