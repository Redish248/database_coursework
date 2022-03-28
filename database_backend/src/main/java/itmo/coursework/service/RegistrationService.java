package itmo.coursework.service;

import itmo.coursework.entity.statistic.Users;
import itmo.coursework.model.NewUser;

public interface RegistrationService {

    public Users registerNewUser(NewUser newUser);

}
