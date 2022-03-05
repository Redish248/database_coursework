package itmo.coursework.impl;

import itmo.coursework.entity.FeedAvailability;
import itmo.coursework.entity.FeedTypes;
import itmo.coursework.repository.FeedAvailabilityRepository;
import itmo.coursework.repository.FeedTypesRepository;
import itmo.coursework.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {
    private final FeedAvailabilityRepository feedAvailabilityRepository;
    private final FeedTypesRepository feedTypesRepository;

    @Override
    public FeedTypes getFeedTypesByUid(long uid) {
        return feedTypesRepository.findFeedTypesByUid(uid);
    }

    @Override
    public List<FeedTypes> getFeedTypesByName(String name) {
        return feedTypesRepository.findFeedTypesByName(name);
    }

    @Override
    public FeedAvailability getFeedAvailabilityByUid(long uid) {
        return feedAvailabilityRepository.findFeedAvailabilityByUid(uid);
    }

    @Override
    public List<FeedAvailability> getFeedAvailabilitiesByFeedType(FeedTypes feedType) {
        return feedAvailabilityRepository.findFeedAvailabilitiesByFeedType(feedType);
    }

    @Override
    public List<FeedAvailability> getFeedAvailabilitiesByAmountGreaterThan(int amount) {
        return feedAvailabilityRepository.findFeedAvailabilitiesByAmountGreaterThan(amount);
    }

    @Override
    public List<FeedAvailability> getFeedAvailabilitiesByAmountLessThan(int amount) {
        return feedAvailabilityRepository.findFeedAvailabilitiesByAmountLessThan(amount);
    }
}
