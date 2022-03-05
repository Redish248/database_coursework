package itmo.coursework.controller;

import itmo.coursework.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databases/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;
}
