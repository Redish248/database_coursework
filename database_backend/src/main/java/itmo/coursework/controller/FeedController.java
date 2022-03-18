package itmo.coursework.controller;

import itmo.coursework.entity.statistic.Feed;
import itmo.coursework.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/databases/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;

    @GetMapping( "/getAllFeed")
    public @ResponseBody ResponseEntity getAllFeed() {
        List<Feed> feedAvailabilityList = feedService.getAllFeeds();
        return ResponseEntity.status(HttpStatus.OK).body(feedAvailabilityList);
    }

    @PostMapping( "/createFeed")
    public @ResponseBody ResponseEntity createFeed(String feed_type, String description, int price, int amount) {
        Feed feed = feedService.createFeed(feed_type, description, price, amount);
        return ResponseEntity.status(HttpStatus.CREATED).body(feed);
    }

    @PostMapping( "/deleteFeed")
    public @ResponseBody ResponseEntity deleteFeed(long uid) {
        feedService.deleteFeed(uid);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @PostMapping( "/updateFeed")
    public @ResponseBody ResponseEntity updateFeed(long uid, String name, String description, int price, int amount) {
        feedService.updateFeed(uid, name, description, price, amount);
        return ResponseEntity.status(HttpStatus.OK).body("updated");
    }

    @GetMapping( "/findFeedByName")
    public @ResponseBody ResponseEntity findFeedByType(String name) {
        List<Feed> feeds = feedService.getFeedByName(name);
        return ResponseEntity.status(HttpStatus.OK).body(feeds);
    }

}
