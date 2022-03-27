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
    public Feed createFeed(Feed newFeed) {
        Feed feed = new Feed();
        feed.setName(newFeed.getName());
        feed.setDescription(newFeed.getDescription());
        feed.setPrice(newFeed.getPrice());
        feed.setAmount(newFeed.getAmount());
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
    public Feed updateFeed(Feed receivedFeed) {
        Feed oldFeed = feedRepository.findFeedByUid(receivedFeed.getUid());
        Optional.ofNullable(oldFeed).ifPresentOrElse(
                optOldFeed -> {
                    optOldFeed.setName(receivedFeed.getName());
                    optOldFeed.setDescription(receivedFeed.getDescription());
                    optOldFeed.setPrice(receivedFeed.getPrice());
                    optOldFeed.setAmount(receivedFeed.getAmount());
                    feedRepository.save(optOldFeed);
                },
                () -> {
                    throw new FeedNotFoundException(String.format("Feed with uid %d does not exist", receivedFeed.getUid()));
                }
        );
        return receivedFeed;
    }
}
