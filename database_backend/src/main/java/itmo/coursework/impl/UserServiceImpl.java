package itmo.coursework.impl;

import itmo.coursework.entity.statistic.UserType;
import itmo.coursework.entity.statistic.Users;
import itmo.coursework.repository.statistic.UserTypeRepository;
import itmo.coursework.repository.statistic.UsersRepository;
import itmo.coursework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository userRepository;
    private final UserTypeRepository userTypeRepository;

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
    public void createUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public UserType getUserTypeByUid(long uid) {
        return userTypeRepository.findUserTypeByUid(uid);
    }

    @Override
    public List<UserType> getUserTypesByName(String name) {
        return userTypeRepository.findUserTypesByName(name);
    }


}
