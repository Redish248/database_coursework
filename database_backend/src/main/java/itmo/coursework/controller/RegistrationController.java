package itmo.coursework.controller;

import itmo.coursework.entity.Users;
import itmo.coursework.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/databases")
@EnableAutoConfiguration
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping( "/signup")
    public @ResponseBody
    ResponseEntity registerUser(String nick, String password, String name, String surname, String email, String gender) {
       Users user = new Users();
        user.setName(name);
        user.setSurname(surname);
        user.setEmail(email);
        user.setGender(gender);
        //TODO: add user type and birthday
        user.setUserType(userService.findUserTypeByUid(1));
        //user.setDateOfBirth();
        user.setNick(nick);
        user.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));

        Users someUser = userService.getUserByNick(nick);
        if (someUser != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
