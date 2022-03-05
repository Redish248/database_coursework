package itmo.coursework.service;

import itmo.coursework.entity.Objects;
import itmo.coursework.entity.ObjectsAvailability;

import java.util.List;

public interface ObjectsService {
    Objects getObjectsByUid(long uid);

    List<Objects> getObjectsByName(String name);

    List<Objects> getObjectsByPriceGreaterThan(int price);

    List<Objects> getObjectsByPriceLessThan(int price);

    ObjectsAvailability getObjectsAvailabilityByUid(long uid);

    List<ObjectsAvailability> getObjectsAvailabilitiesByObjectType(Objects objectType);

    List<ObjectsAvailability> getObjectsAvailabilitiesByAmountGreaterThan(int amount);

    List<ObjectsAvailability> getObjectsAvailabilitiesByAmountLessThan(int amount);
}
