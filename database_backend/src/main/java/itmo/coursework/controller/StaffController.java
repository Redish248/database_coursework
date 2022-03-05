package itmo.coursework.controller;

import itmo.coursework.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;
}
