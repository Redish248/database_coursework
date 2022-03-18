package itmo.coursework.repository.statistic;

import itmo.coursework.entity.statistic.UserType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserTypeRepository extends CrudRepository<UserType, Long> {
    UserType findUserTypeByUid(long uid);

    List<UserType> findUserTypesByName(String name);
}
