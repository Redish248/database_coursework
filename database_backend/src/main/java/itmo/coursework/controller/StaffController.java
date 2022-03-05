package itmo.coursework.controller;

import itmo.coursework.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databases/staff")
@RequiredArgsConstructor
public class StaffController {
    private final StaffService staffService;
}
