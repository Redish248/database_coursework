package itmo.coursework.impl;

import itmo.coursework.repository.FeedAvailabilityRepository;
import itmo.coursework.repository.FeedTypesRepository;
import itmo.coursework.service.FeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedServiceImpl implements FeedService {
    private final FeedAvailabilityRepository feedAvailabilityRepository;
    private final FeedTypesRepository feedTypesRepository;
}
