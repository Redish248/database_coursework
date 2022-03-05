package itmo.coursework.controller;

import itmo.coursework.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequiredArgsConstructor
public class ObjectsController {
    private final ObjectsService objectsService;
}
