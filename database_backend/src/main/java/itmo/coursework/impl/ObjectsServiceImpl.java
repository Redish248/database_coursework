package itmo.coursework.impl;

import itmo.coursework.entity.Objects;
import itmo.coursework.repository.ObjectsRepository;
import itmo.coursework.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObjectsServiceImpl implements ObjectsService {
    private final ObjectsRepository objectsRepository;


    @Override
    public Objects findObjectsByUid(long uid) {
        return objectsRepository.findObjectsByUid(uid);
    }

    @Override
    public List<Objects> findObjectsByName(String name) {
        return objectsRepository.findObjectsByName(name);
    }

    @Override
    public List<Objects> findObjectsByPriceGreaterThan(int price) {
        return objectsRepository.findObjectsByPriceGreaterThan(price);
    }

    @Override
    public List<Objects> findObjectsByPriceLessThan(int price) {
        return objectsRepository.findObjectsByPriceLessThan(price);
    }

    @Override
    public List<Objects> findObjectsByAmountGreaterThan(int amount) {
        return objectsRepository.findObjectsByAmountGreaterThan(amount);
    }

    @Override
    public List<Objects> findObjectsByAmountLessThan(int amount) {
        return objectsRepository.findObjectsByAmountLessThan(amount);
    }
}
