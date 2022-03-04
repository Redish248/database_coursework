package itmo.coursework.impl;

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
}
