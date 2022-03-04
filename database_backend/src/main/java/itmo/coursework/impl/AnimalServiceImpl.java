package itmo.coursework.impl;

import itmo.coursework.repository.AnimalStatisticsRepository;
import itmo.coursework.repository.AnimalTypeRepository;
import itmo.coursework.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnimalServiceImpl implements AnimalService {
    private final AnimalStatisticsRepository animalStatisticsRepository;
    private final AnimalTypeRepository animalTypeRepository;
}
