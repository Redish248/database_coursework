package itmo.coursework.repository;

import itmo.coursework.entity.UserType;
import itmo.coursework.entity.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
    Users findUsersByUid(long uid);

    Users findUsersByNickAndPassword(String nick, String password);

    Users findUsersByNick(String nick);

    Users findUsersByEmail(String email);

    List<Users> findUsersByUserType(UserType userType);
}
