package itmo.coursework.service;

import itmo.coursework.entity.Feed;

import java.util.List;

public interface FeedService {

    List<Feed> getAllFeeds();

    Feed getFeedByUid(long uid);

    List<Feed> getFeedByName(String name);

    List<Feed> getFeedsByAmountGreaterThan(int amount);

    List<Feed> getFeedsByAmountLessThan(int amount);

    List<Feed> findFeedsByPriceGreaterThan(int price);

    List<Feed> findFeedsByPriceLessThan(int price);
}
