package itmo.coursework.impl;

import itmo.coursework.repository.ObjectsAvailabilityRepository;
import itmo.coursework.repository.ObjectsRepository;
import itmo.coursework.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ObjectsServiceImpl implements ObjectsService {
    private final ObjectsRepository objectsRepository;
    private final ObjectsAvailabilityRepository objectsAvailabilityRepository;
}
