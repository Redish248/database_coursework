package itmo.coursework.repository;

import itmo.coursework.entity.AnimalStatistics;
import itmo.coursework.entity.AnimalType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalStatisticsRepository extends CrudRepository<AnimalStatistics, Long> {
    AnimalStatisticsRepository findAnimalStatisticsByUid(long uid);

    List<AnimalStatistics> findAnimalStatisticsByAnimal(AnimalType animal);

    List<AnimalStatistics> findAnimalStatisticsByAmountGreaterThan(int amount);

    List<AnimalStatistics> findAnimalStatisticsByAmountLessThan(int amount);
}
