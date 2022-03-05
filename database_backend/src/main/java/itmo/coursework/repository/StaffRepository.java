package itmo.coursework.repository;

import itmo.coursework.entity.Position;
import itmo.coursework.entity.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long> {
    Staff findStaffByUid(long uid);

    List<Staff> findStaffByNameAndSurname(String name, String surname);

    List<Staff> findStaffBySurname(String surname);

    List<Staff> findStaffByGender(String gender);

    List<Staff> findStaffByPositionType(Position position);

    List<Staff> findStaffBySalaryGreaterThan(int salary);

    List<Staff> findStaffBySalaryLessThan(int salary);
}