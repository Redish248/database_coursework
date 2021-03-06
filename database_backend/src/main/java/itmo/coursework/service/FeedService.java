package itmo.coursework.service;

import itmo.coursework.entity.statistic.Feed;

import java.util.List;

public interface FeedService {

    List<Feed> getAllFeeds();

    Feed createFeed(Feed newFeed);

    void deleteFeed(long uid);

    Feed updateFeed(Feed feed);
}
