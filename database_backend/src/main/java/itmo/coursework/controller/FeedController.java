package itmo.coursework.controller;

import itmo.coursework.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequiredArgsConstructor
public class FeedController {
    private final FeedService feedService;
}
