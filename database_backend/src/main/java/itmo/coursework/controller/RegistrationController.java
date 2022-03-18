package itmo.coursework.controller;

import itmo.coursework.entity.statistic.Users;
import itmo.coursework.model.NewUser;
import itmo.coursework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/databases")
@EnableAutoConfiguration
@RequiredArgsConstructor
public class RegistrationController {

    private final UserService userService;

    @PostMapping("/signup")
    public @ResponseBody
    ResponseEntity registerUser(@RequestBody NewUser newUser) throws ParseException {
        System.out.println(newUser.getNick());
        Users user = new Users();
        user.setName(newUser.getUsername());
        user.setSurname(newUser.getSurname());
        user.setEmail(newUser.getEmail());
        user.setGender(newUser.getGender());

        //TODO: add user type
        user.setUserType(userService.getUserTypeByUid(1));

        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        Date parsed = format.parse(newUser.getDateOfBirth());
        java.sql.Date sqlDate = new java.sql.Date(parsed.getTime());
        user.setDateOfBirth(sqlDate);

        user.setNick(newUser.getNick());
        user.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));

        Users someUser = userService.getUserByNick(newUser.getNick());
        if (someUser != null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User already exists");
        }
        userService.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }
}
