package itmo.coursework.service;

import itmo.coursework.entity.Objects;

import java.util.List;

public interface ObjectsService {
    Objects findObjectsByUid(long uid);

    List<Objects> findObjectsByName(String name);

    List<Objects> findObjectsByPriceGreaterThan(int price);

    List<Objects> findObjectsByPriceLessThan(int price);

    List<Objects> findObjectsByAmountGreaterThan(int amount);

    List<Objects> findObjectsByAmountLessThan(int amount);
}
