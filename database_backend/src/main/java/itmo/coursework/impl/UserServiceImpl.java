package itmo.coursework.impl;

import itmo.coursework.entity.statistic.UserType;
import itmo.coursework.entity.statistic.Users;
import itmo.coursework.model.MainUserInfo;
import itmo.coursework.repository.statistic.UserTypeRepository;
import itmo.coursework.repository.statistic.UsersRepository;
import itmo.coursework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    @Override
    public List<MainUserInfo> getUsers() {
        List<MainUserInfo> users = new ArrayList<>();
        userRepository.findAll().forEach(el -> users.add(new MainUserInfo(el.getUid(), getFullName(el.getName(), el.getSurname()))));
        return users;
    }

    private String getFullName(String name, String surname) {
        return surname + " " + name + " ";
    }

    @Override
    public Users getUsersByUid(long uid) {
        return userRepository.findUsersByUid(uid);
    }

    @Override
    public Users getUsersByNickAndPassword(String nick, String password) {
        return userRepository.findUsersByNickAndPassword(nick, password);
    }

    @Override
    public Users getUserByNick(String nick) {
        return userRepository.findUsersByNick(nick);
    }

    @Override
    public Users getUsersByEmail(String email) {
        return userRepository.findUsersByEmail(email);
    }

    @Override
    public List<Users> getUsersByUserType(UserType userType) {
        return userRepository.findUsersByUserType(userType);
    }

    @Override
    public Users createUser(Users user) {
        return userRepository.save(user);
    }

    @Override
    public UserType getUserTypeByUid(long uid) {
        return userTypeRepository.findUserTypeByUid(uid);
    }

    @Override
    public List<UserType> getUserTypesByName(String name) {
        return userTypeRepository.findUserTypesByName(name);
    }

    @Override
    public Users updateUser(Users user) {
        Users oldUser = userRepository.findUsersByNick(user.getNick());
        Optional.ofNullable(user.getName()).ifPresent(oldUser::setName);
        Optional.ofNullable(user.getSurname()).ifPresent(oldUser::setSurname);
        Optional.ofNullable(user.getDateOfBirth()).ifPresent(oldUser::setDateOfBirth);
        Optional.ofNullable(user.getGender()).ifPresent(oldUser::setGender);
        return userRepository.save(oldUser);
    }

    @Override
    public void deleteUser(Long uid) {
        userRepository.delete(getUsersByUid(uid));
    }

}
