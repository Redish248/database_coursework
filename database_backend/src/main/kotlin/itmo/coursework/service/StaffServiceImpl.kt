package itmo.coursework.service

import itmo.coursework.entity.Position
import itmo.coursework.entity.Staff
import itmo.coursework.exception.StaffNotFoundException
import itmo.coursework.repository.PositionRepository
import itmo.coursework.repository.StaffRepository
import org.springframework.stereotype.Service

@Service
class StaffServiceImpl(
    private val staffRepository: StaffRepository,
    private val positionRepository: PositionRepository
) : StaffService {

    override fun getPositionByUid(uid: Long): Position? = positionRepository.findPositionByUid(uid)

    override fun getPositionByName(name: String?): MutableList<Position> = positionRepository.findPositionByName(name)

    override fun getStaffByUid(uid: Long): Staff =
        staffRepository.findStaffByUid(uid) ?: throw StaffNotFoundException(uid)

    override fun getStaffByNameAndSurname(name: String?, surname: String?): MutableList<Staff> =
        staffRepository.findStaffByNameAndSurname(name, surname)

    override fun getStaffBySurname(surname: String?): MutableList<Staff> = staffRepository.findStaffBySurname(surname)

    // fixme - gender ? find all women ? sound strange...
    override fun getStaffByGender(gender: String?): MutableList<Staff> = staffRepository.findStaffByGender(gender)

    override fun getStaffByPositionType(position: Position): MutableList<Staff> =
        staffRepository.findStaffByPositionType(position)

    override fun getStaffBySalaryGreaterThan(minSalary: Int): MutableList<Staff> =
        staffRepository.findStaffBySalaryGreaterThan(minSalary)

    override fun getStaffBySalaryLessThan(maxSalary: Int): MutableList<Staff> =
        staffRepository.findStaffBySalaryLessThan(maxSalary)
}