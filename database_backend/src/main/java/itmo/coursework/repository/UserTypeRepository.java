package itmo.coursework.repository;

import itmo.coursework.entity.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Long> {
    UserType findUserTypeByUid(long uid);

    List<UserType> findUserTypesByName(String name);
}
