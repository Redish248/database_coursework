package itmo.coursework.controller;

import itmo.coursework.service.AnimalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databases/animal")
@RequiredArgsConstructor
public class AnimalController {
    private final AnimalService animalService;
}
