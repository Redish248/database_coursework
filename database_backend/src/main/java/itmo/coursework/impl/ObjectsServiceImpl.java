package itmo.coursework.impl;

import itmo.coursework.entity.Objects;
import itmo.coursework.entity.ObjectsAvailability;
import itmo.coursework.repository.ObjectsAvailabilityRepository;
import itmo.coursework.repository.ObjectsRepository;
import itmo.coursework.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectsServiceImpl implements ObjectsService {
    private final ObjectsRepository objectsRepository;
    private final ObjectsAvailabilityRepository objectsAvailabilityRepository;

    @Override
    public Objects getObjectsByUid(long uid) {
        return objectsRepository.findObjectsByUid(uid);
    }

    @Override
    public List<Objects> getObjectsByName(String name) {
        return objectsRepository.findObjectsByName(name);
    }

    @Override
    public List<Objects> getObjectsByPriceGreaterThan(int price) {
        return objectsRepository.findObjectsByPriceGreaterThan(price);
    }

    @Override
    public List<Objects> getObjectsByPriceLessThan(int price) {
        return objectsRepository.findObjectsByPriceLessThan(price);
    }

    @Override
    public ObjectsAvailability getObjectsAvailabilityByUid(long uid) {
        return objectsAvailabilityRepository.findObjectsAvailabilityByUid(uid);
    }

    @Override
    public List<ObjectsAvailability> getObjectsAvailabilitiesByObjectType(Objects objectType) {
        return objectsAvailabilityRepository.findObjectsAvailabilitiesByObjectType(objectType);
    }

    @Override
    public List<ObjectsAvailability> getObjectsAvailabilitiesByAmountGreaterThan(int amount) {
        return objectsAvailabilityRepository.findObjectsAvailabilitiesByAmountGreaterThan(amount);
    }

    @Override
    public List<ObjectsAvailability> getObjectsAvailabilitiesByAmountLessThan(int amount) {
        return objectsAvailabilityRepository.findObjectsAvailabilitiesByAmountLessThan(amount);
    }
}
