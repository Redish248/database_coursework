package itmo.coursework.service;

import itmo.coursework.entity.Feed;

import java.util.List;

public interface FeedService {

    List<Feed> getAllFeeds();

    List<Feed> getFeedByName(String name);

    Feed createFeed(String feed_type, String description, int price, int amount);

    void deleteFeed(long uid);

    void updateFeed(long uid, String name, String description, int price, int amount);
}
