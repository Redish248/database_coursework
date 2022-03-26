package itmo.coursework.repository.statistic;

import itmo.coursework.entity.statistic.Position;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PositionRepository extends CrudRepository<Position, Long> {

    @NotNull
    List<Position> findAll();

    Position findPositionByUid(long uid);

    List<Position> findPositionByName(String name);
}
