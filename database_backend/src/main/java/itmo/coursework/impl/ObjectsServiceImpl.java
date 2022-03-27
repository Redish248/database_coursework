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
    public Objects createObject(Objects newObject) {
        Objects object = new Objects();
        object.setName(newObject.getName());
        object.setDescription(newObject.getDescription());
        object.setPrice(newObject.getPrice());
        object.setAmount(newObject.getAmount());
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
    public Objects updateObject(Objects receivedObject) {
        Objects oldObject = objectsRepository.findObjectsByUid(receivedObject.getUid());
        Optional.ofNullable(oldObject).ifPresentOrElse(
                optOldObject -> {
                    optOldObject.setName(receivedObject.getName());
                    optOldObject.setDescription(receivedObject.getDescription());
                    optOldObject.setPrice(receivedObject.getPrice());
                    optOldObject.setAmount(receivedObject.getAmount());
                    objectsRepository.save(optOldObject);
                },
                () -> {
                    throw new ObjectNotFoundException(String.format("Object with uid %d does not exist", receivedObject.getUid()));
                }
        );
        return receivedObject;
    }
}
