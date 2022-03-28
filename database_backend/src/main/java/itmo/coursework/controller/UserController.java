package itmo.coursework.controller;

import itmo.coursework.entity.statistic.Users;
import itmo.coursework.model.NewUser;
import itmo.coursework.service.CreateUsersService;
import itmo.coursework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/databases/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    private final CreateUsersService createUsers;

    @GetMapping("/getUserByNick")

    public @ResponseBody
    ResponseEntity registerUser(@RequestParam String nick) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUserByNick(nick));
    }

    @PostMapping("/updateUser")
    public @ResponseBody
    ResponseEntity registerUser(@RequestBody Users newUser) {
        Users user = userService.updateUser(newUser);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

    @PostMapping("/create")
    public ResponseEntity createDefaultUsers() {
        createUsers.createUsers();
        return ResponseEntity.status(HttpStatus.OK).body("ok");
    }

}
