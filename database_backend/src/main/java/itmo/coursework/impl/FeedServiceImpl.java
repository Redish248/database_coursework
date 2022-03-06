package itmo.coursework.impl;

import itmo.coursework.entity.Feed;
import itmo.coursework.repository.FeedRepository;
import itmo.coursework.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {
    private final FeedRepository feedRepository;

    @Override
    public List<Feed> getAllFeeds() {
        return (List<Feed>) feedRepository.findAll();
    }

    @Override
    public Feed getFeedByUid(long uid) {
        return feedRepository.findFeedByUid(uid);
    }

    @Override
    public List<Feed> getFeedByName(String name) {
        return feedRepository.findFeedsByName(name);
    }

    @Override
    public List<Feed> getFeedsByAmountGreaterThan(int amount) {
        return feedRepository.findFeedsByAmountGreaterThan(amount);
    }

    @Override
    public List<Feed> getFeedsByAmountLessThan(int amount) {
        return feedRepository.findFeedsByAmountLessThan(amount);
    }

    @Override
    public List<Feed> findFeedsByPriceGreaterThan(int price) {
        return feedRepository.findFeedsByPriceGreaterThan(price);
    }

    @Override
    public List<Feed> findFeedsByPriceLessThan(int price) {
        return feedRepository.findFeedsByPriceLessThan(price);
    }
}
