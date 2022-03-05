package itmo.coursework.service;

import itmo.coursework.entity.UserType;
import itmo.coursework.entity.Users;

public interface UserService {

    Users getUserByNick(String nick);

    void createUser(Users user);

    UserType findUserTypeByUid(long uid);

}
