package itmo.coursework.repository;

import itmo.coursework.entity.FeedAvailability;
import itmo.coursework.entity.FeedTypes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedAvailabilityRepository extends CrudRepository<FeedAvailability, Long> {
    FeedAvailability findFeedAvailabilityByUid(long uid);

    List<FeedAvailability> findFeedAvailabilitiesByFeedType(FeedTypes feedType);

    List<FeedAvailability> findFeedAvailabilitiesByAmountGreaterThan(int amount);

    List<FeedAvailability> findFeedAvailabilitiesByAmountLessThan(int amount);
}
