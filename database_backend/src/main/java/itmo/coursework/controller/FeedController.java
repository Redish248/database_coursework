package itmo.coursework.controller;

import itmo.coursework.entity.Feed;
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

    @GetMapping( "/getAllFeed/paging")
    public @ResponseBody ResponseEntity getAllFeedByPages(int startIndex, int endIndex) {
        List<Feed> feedAvailabilityList = feedService.getAllFeeds();
        if (endIndex > feedAvailabilityList.size()) {
            endIndex = feedAvailabilityList.size();
        }
        feedAvailabilityList = feedAvailabilityList.subList(startIndex, endIndex);
        return ResponseEntity.status(HttpStatus.OK).body(feedAvailabilityList);
    }

    @PostMapping( "/createFeed")
    public @ResponseBody ResponseEntity createFeed(String feed_type) {

        return ResponseEntity.status(HttpStatus.OK).body("created");
    }

    @PostMapping( "/deleteFeed")
    public @ResponseBody ResponseEntity deleteFeed(int uid) {

        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @PostMapping( "/increaseFeed")
    public @ResponseBody ResponseEntity increaseFeed(int uid) {

        return ResponseEntity.status(HttpStatus.OK).body("increased");
    }

    @PostMapping( "/decreaseFeed")
    public @ResponseBody ResponseEntity decreaseFeed(int uid) {

        return ResponseEntity.status(HttpStatus.OK).body("decreased");
    }

    @PostMapping( "/findFeedByType")
    public @ResponseBody ResponseEntity findFeedByType(int uid) {

        return ResponseEntity.status(HttpStatus.OK).body("");
    }

}
