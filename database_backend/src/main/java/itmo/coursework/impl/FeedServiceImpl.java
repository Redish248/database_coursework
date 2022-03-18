package itmo.coursework.impl;

import itmo.coursework.entity.statistic.Feed;
import itmo.coursework.exception.FeedNotFoundException;
import itmo.coursework.repository.statistic.FeedRepository;
import itmo.coursework.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {
    private final FeedRepository feedRepository;

    @Override
    public List<Feed> getAllFeeds() {
        return (List<Feed>) feedRepository.findAll();
    }

    @Override
    public List<Feed> getFeedByName(String name) {
        return feedRepository.findFeedsByName(name);
    }

    @Override
    public Feed createFeed(String feed_type, String description, int price, int amount) {
        Feed feed = new Feed();
        feed.setName(feed_type);
        feed.setDescription(description);
        feed.setPrice(price);
        feed.setAmount(amount);
        return feedRepository.save(feed);
    }

    @Override
    public void deleteFeed(long uid) {
        Feed feed = feedRepository.findFeedByUid(uid);
        Optional.ofNullable(feed).ifPresentOrElse(
                feedRepository::delete,
                () -> {
                    throw new FeedNotFoundException(String.format("Feed with uid %d does not exist", uid));
                }
        );
    }

    @Override
    public void updateFeed(long uid, String name, String description, int price, int amount) {
        Feed oldFeed = feedRepository.findFeedByUid(uid);
        Optional.ofNullable(oldFeed).ifPresentOrElse(
                optOldFeed -> {
                    optOldFeed.setName(name);
                    optOldFeed.setDescription(description);
                    optOldFeed.setPrice(price);
                    optOldFeed.setAmount(amount);
                    feedRepository.save(optOldFeed);
                },
                () -> {
                    throw new FeedNotFoundException(String.format("Feed with uid %d does not exist", uid));
                }
        );
    }
}
