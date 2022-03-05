package itmo.coursework.controller;

import itmo.coursework.service.ObjectsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databases/object")
@RequiredArgsConstructor
public class ObjectsController {
    private final ObjectsService objectsService;
}
