package itmo.coursework.impl;

import itmo.coursework.entity.UserType;
import itmo.coursework.entity.Users;
import itmo.coursework.repository.UserTypeRepository;
import itmo.coursework.repository.UsersRepository;
import itmo.coursework.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UsersRepository userRepository;
    private final UserTypeRepository userTypeRepository;

    @Override
    public Users getUserByNick(String nick) {
        return userRepository.findUsersByNick(nick);
    }

    @Override
    public void createUser(Users user) {
        userRepository.save(user);
    }

    @Override
    public UserType findUserTypeByUid(long uid) {
        return userTypeRepository.findUserTypeByUid(uid);
    }


}
