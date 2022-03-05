package itmo.coursework.service;

import itmo.coursework.entity.UserType;
import itmo.coursework.entity.Users;

import java.util.List;

public interface UserService {

    Users getUsersByUid(long uid);

    Users getUsersByNickAndPassword(String nick, String password);

    Users getUserByNick(String nick);

    Users getUsersByEmail(String email);

    List<Users> getUsersByUserType(UserType userType);

    void createUser(Users user);

    UserType getUserTypeByUid(long uid);

    List<UserType> getUserTypesByName(String name);

}
