package itmo.coursework.service;

import itmo.coursework.entity.statistic.UserType;
import itmo.coursework.entity.statistic.Users;
import itmo.coursework.model.MainUserInfo;

import java.util.List;

public interface UserService {

    List<MainUserInfo> getUsers();

    Users getUsersByUid(long uid);

    Users getUsersByNickAndPassword(String nick, String password);

    Users getUserByNick(String nick);

    Users getUsersByEmail(String email);

    List<Users> getUsersByUserType(UserType userType);

    Users createUser(Users user);

    UserType getUserTypeByUid(long uid);

    List<UserType> getUserTypesByName(String name);

    Users updateUser(Users user);

    void deleteUser(Long uid);
}
