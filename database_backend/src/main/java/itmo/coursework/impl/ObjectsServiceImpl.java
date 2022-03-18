package itmo.coursework.impl;

import itmo.coursework.entity.statistic.Objects;
import itmo.coursework.exception.ObjectNotFoundException;
import itmo.coursework.repository.statistic.ObjectsRepository;
import itmo.coursework.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ObjectsServiceImpl implements ObjectsService {
    private final ObjectsRepository objectsRepository;


    @Override
    public List<Objects> getAllObjects() {
        return (List<Objects>) objectsRepository.findAll();
    }

    @Override
    public Objects findObjectsByUid(long uid) {
        return objectsRepository.findObjectsByUid(uid);
    }

    @Override
    public List<Objects> findObjectsByName(String name) {
        return objectsRepository.findObjectsByName(name);
    }

    @Override
    public Objects createObject(String name, String description, int price, int amount) {
        Objects object = new Objects();
        object.setName(name);
        object.setDescription(description);
        object.setPrice(price);
        object.setAmount(amount);
        return objectsRepository.save(object);
    }

    @Override
    public void deleteObject(long uid) {
        Objects object = objectsRepository.findObjectsByUid(uid);
        Optional.ofNullable(object).ifPresentOrElse(
                objectsRepository::delete,
                () -> {
                    throw new ObjectNotFoundException(String.format("Object with uid %d does not exist", uid));
                }
        );
    }

    @Override
    public void updateObject(long uid, String name, String description, int price, int amount) {
        Objects oldObject = objectsRepository.findObjectsByUid(uid);
        Optional.ofNullable(oldObject).ifPresentOrElse(
                optOldObject -> {
                    optOldObject.setName(name);
                    optOldObject.setDescription(description);
                    optOldObject.setPrice(price);
                    optOldObject.setAmount(amount);
                    objectsRepository.save(optOldObject);
                },
                () -> {
                    throw new ObjectNotFoundException(String.format("Object with uid %d does not exist", uid));
                }
        );
    }
}
