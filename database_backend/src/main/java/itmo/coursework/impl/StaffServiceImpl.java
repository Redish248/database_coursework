package itmo.coursework.impl;

import itmo.coursework.entity.Position;
import itmo.coursework.entity.Staff;
import itmo.coursework.repository.PositionRepository;
import itmo.coursework.repository.StaffRepository;
import itmo.coursework.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private final StaffRepository staffRepository;
    private final PositionRepository positionRepository;

    @Override
    public Position getPositionByUid(long uid) {
        return positionRepository.findPositionByUid(uid);
    }

    @Override
    public List<Position> getPositionByName(String name) {
        return positionRepository.findPositionByName(name);
    }

    @Override
    public Staff getStaffByUid(long uid) {
        return staffRepository.findStaffByUid(uid);
    }

    @Override
    public List<Staff> getStaffByNameAndSurname(String name, String surname) {
        return staffRepository.findStaffByNameAndSurname(name, surname);
    }

    @Override
    public List<Staff> getStaffBySurname(String surname) {
        return staffRepository.findStaffBySurname(surname);
    }

    @Override
    public List<Staff> getStaffByGender(String gender) {
        return staffRepository.findStaffByGender(gender);
    }

    @Override
    public List<Staff> getStaffByPositionType(Position position) {
        return staffRepository.findStaffByPositionType(position);
    }

    @Override
    public List<Staff> getStaffBySalaryGreaterThan(int salary) {
        return staffRepository.findStaffBySalaryGreaterThan(salary);
    }

    @Override
    public List<Staff> getStaffBySalaryLessThan(int salary) {
        return staffRepository.findStaffBySalaryLessThan(salary);
    }
}
