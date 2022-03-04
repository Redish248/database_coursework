package itmo.coursework.repository;

import itmo.coursework.entity.AnimalStatistics;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalStatisticsRepository extends CrudRepository<AnimalStatistics, Long> {
    AnimalStatisticsRepository findAnimalStatisticsByUid(long uid);
}
