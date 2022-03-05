package itmo.coursework.service;

import itmo.coursework.entity.FeedAvailability;
import itmo.coursework.entity.FeedTypes;

import java.util.List;

public interface FeedService {
    FeedTypes getFeedTypesByUid(long uid);

    List<FeedTypes> getFeedTypesByName(String name);

    FeedAvailability getFeedAvailabilityByUid(long uid);

    List<FeedAvailability> getFeedAvailabilitiesByFeedType(FeedTypes feedType);

    List<FeedAvailability> getFeedAvailabilitiesByAmountGreaterThan(int amount);

    List<FeedAvailability> getFeedAvailabilitiesByAmountLessThan(int amount);
}
