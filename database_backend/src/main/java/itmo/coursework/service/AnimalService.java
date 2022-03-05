package itmo.coursework.service;

import itmo.coursework.entity.AnimalStatistics;
import itmo.coursework.entity.AnimalType;

import java.util.List;

public interface AnimalService {

    AnimalType getAnimalTypeByUid(long uid);

    AnimalType getAnimalTypeByName(String name);

    AnimalStatistics getAnimalStatisticsByUid(long uid);

    List<AnimalStatistics> getAnimalStatisticsByAnimal(AnimalType animal);

    List<AnimalStatistics> getAnimalStatisticsByAmountGreaterThan(int amount);

    List<AnimalStatistics> getAnimalStatisticsByAmountLessThan(int amount);
}
