package itmo.coursework.service;

import itmo.coursework.entity.statistic.Position;
import itmo.coursework.entity.statistic.Staff;

import java.util.List;

public interface StaffService {
    Position getPositionByUid(long uid);

    List<Position> getPositions();

    List<Position> getPositionByName(String name);

    void saveStaff(Staff newStaff);

    void deleteStaff(Long uid);

    List<Staff> getStaff();

    Staff getStaffByUid(long uid);

    List<Staff> getStaffByNameAndSurname(String name, String surname);

    List<Staff> getStaffBySurname(String surname);

    List<Staff> getStaffByGender(String gender);

    List<Staff> getStaffByPositionType(Position position);

    List<Staff> getStaffBySalaryGreaterThan(int salary);

    List<Staff> getStaffBySalaryLessThan(int salary);

    List<Staff> getExperiencedStaff(int minExperience);
}
