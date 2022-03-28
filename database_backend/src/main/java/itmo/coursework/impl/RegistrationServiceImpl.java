package itmo.coursework.impl;

import itmo.coursework.entity.statistic.UserType;
import itmo.coursework.entity.statistic.Users;
import itmo.coursework.exception.UserAlreadyExistException;
import itmo.coursework.model.NewUser;
import itmo.coursework.service.RegistrationService;
import itmo.coursework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import static itmo.coursework.CommonUtilsKt.parseStringToSqlDate;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserService userService;

    @Override
    public Users registerNewUser(NewUser newUser) {
        System.out.println(newUser.getNick());
        Users user = new Users();
        user.setName(newUser.getUsername());
        user.setSurname(newUser.getSurname());
        user.setEmail(newUser.getEmail());
        user.setGender(newUser.getGender());

        UserType role = userService.getUserTypesByName(newUser.getRole().name()).get(0);
        user.setUserType(role);
        user.setDateOfBirth(parseStringToSqlDate(newUser.getDateOfBirth()));

        user.setNick(newUser.getNick());
        user.setPassword(BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt()));

        Users someUser = userService.getUserByNick(newUser.getNick());
        if (someUser != null) {
            throw new UserAlreadyExistException(newUser.getNick());
        }
        userService.createUser(user);
        return user;
    }

}
