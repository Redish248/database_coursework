package itmo.coursework.impl;

import itmo.coursework.entity.AnimalStatistics;
import itmo.coursework.entity.AnimalType;
import itmo.coursework.repository.AnimalStatisticsRepository;
import itmo.coursework.repository.AnimalTypeRepository;
import itmo.coursework.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalStatisticsRepository animalStatisticsRepository;
    private final AnimalTypeRepository animalTypeRepository;

    @Override
    public AnimalType getAnimalTypeByUid(long uid) {
        return animalTypeRepository.findAnimalTypeByUid(uid);
    }

    @Override
    public AnimalType getAnimalTypeByName(String name) {
        return animalTypeRepository.findAnimalTypeByName(name);
    }

    @Override
    public AnimalStatistics getAnimalStatisticsByUid(long uid) {
        return animalStatisticsRepository.findAnimalStatisticsByUid(uid);
    }

    @Override
    public List<AnimalStatistics> getAnimalStatisticsByAnimal(AnimalType animal) {
        return animalStatisticsRepository.findAnimalStatisticsByAnimal(animal);
    }

    @Override
    public List<AnimalStatistics> getAnimalStatisticsByAmountGreaterThan(int amount) {
        return animalStatisticsRepository.findAnimalStatisticsByAmountGreaterThan(amount);
    }

    @Override
    public List<AnimalStatistics> getAnimalStatisticsByAmountLessThan(int amount) {
        return animalStatisticsRepository.findAnimalStatisticsByAmountLessThan(amount);
    }
}
