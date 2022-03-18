package itmo.coursework.repository.statistic;

import itmo.coursework.entity.statistic.Position;
import itmo.coursework.entity.statistic.Staff;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {
    Staff findStaffByUid(long uid);

    @NotNull
    List<Staff> findAll();

    List<Staff> findStaffByNameAndSurname(String name, String surname);

    List<Staff> findStaffBySurname(String surname);

    List<Staff> findStaffByGender(String gender);

    List<Staff> findStaffByPositionType(Position position);

    List<Staff> findStaffBySalaryGreaterThan(int salary);

    List<Staff> findStaffBySalaryLessThan(int salary);

    List<Staff> findAllByExperienceGreaterThan(int minExperience);
}
