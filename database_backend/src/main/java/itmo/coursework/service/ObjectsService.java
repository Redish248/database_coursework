package itmo.coursework.service;

import itmo.coursework.entity.statistic.Objects;

import java.util.List;

public interface ObjectsService {

    List<Objects> getAllObjects();

    Objects createObject(Objects newObject);

    void deleteObject(long uid);

    Objects updateObject(Objects object);

}
