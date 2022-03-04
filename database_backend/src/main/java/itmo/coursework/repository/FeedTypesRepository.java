package itmo.coursework.repository;

import itmo.coursework.entity.FeedTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedTypesRepository extends CrudRepository<FeedTypes, Long> {
    FeedTypes findFeedTypesByUid(long uid);

    List<FeedTypes> findFeedTypesByName(String name);
}
