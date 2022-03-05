package itmo.coursework.controller;

import itmo.coursework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databases/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
}
