package itmo.coursework.service;

import itmo.coursework.entity.statistic.Objects;

import java.util.List;

public interface ObjectsService {

    List<Objects> getAllObjects();

    Objects findObjectsByUid(long uid);

    List<Objects> findObjectsByName(String name);

    Objects createObject(String name, String description, int price, int amount);

    void deleteObject(long uid);

    void updateObject(long uid, String name, String description, int price, int amount);

}
