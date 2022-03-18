package itmo.coursework.service;

import itmo.coursework.entity.statistic.Animals;

import java.util.List;

public interface AnimalService {

    Animals getAnimalByUid(long uid);

    Animals getAnimalByName(String name);

    List<Animals> getAnimalsByAmountGreaterThan(int amount);

    List<Animals> getAnimalsByAmountLessThan(int amount);
}
