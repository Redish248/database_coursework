package itmo.coursework.controller;

import itmo.coursework.entity.statistic.Feed;
import itmo.coursework.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public @ResponseBody ResponseEntity createFeed(@RequestBody Feed newFeed) {
        Feed feed = feedService.createFeed(newFeed);
        return ResponseEntity.status(HttpStatus.CREATED).body(feed);
    }

    @PostMapping( "/deleteFeed/{uid}")
    public @ResponseBody ResponseEntity deleteFeed(@PathVariable long uid) {
        feedService.deleteFeed(uid);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @PostMapping( "/updateFeed")
    public @ResponseBody ResponseEntity updateFeed(@RequestBody Feed feed) {
        Feed newFeed = feedService.updateFeed(feed);
        return ResponseEntity.status(HttpStatus.OK).body(newFeed);
    }

}
