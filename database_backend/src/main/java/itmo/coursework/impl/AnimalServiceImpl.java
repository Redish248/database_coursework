package itmo.coursework.impl;

import itmo.coursework.entity.statistic.Animals;
import itmo.coursework.repository.statistic.AnimalsRepository;
import itmo.coursework.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalsRepository animalTypeRepository;

    @Override
    public Animals getAnimalByUid(long uid) {
        return animalTypeRepository.findAnimalsByUid(uid);
    }

    @Override
    public Animals getAnimalByName(String name) {
        return animalTypeRepository.findAnimalsByName(name);
    }

    @Override
    public List<Animals> getAnimalsByAmountGreaterThan(int amount) {
        return animalTypeRepository.findAnimalsByAmountGreaterThan(amount);
    }

    @Override
    public List<Animals> getAnimalsByAmountLessThan(int amount) {
        return animalTypeRepository.findAnimalsByAmountLessThan(amount);
    }
}
