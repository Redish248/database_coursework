package itmo.coursework.service

import itmo.coursework.entity.statistic.Position
import itmo.coursework.entity.statistic.Staff
import itmo.coursework.exception.StaffNotFoundException
import itmo.coursework.model.AddNewStaffRequest
import itmo.coursework.repository.statistic.PositionRepository
import itmo.coursework.repository.statistic.StaffRepository
import org.springframework.stereotype.Service
import java.security.Principal

@Service
class StaffServiceImpl(
    private val staffRepository: StaffRepository,
    private val positionRepository: PositionRepository
) : StaffService {

    fun getStaff(user: Principal) : Collection<Staff>{
        println("user : ${user.name}")
        return staffRepository.findAll()
    }
    override fun getPositionByUid(uid: Long): Position? = positionRepository.findPositionByUid(uid)

    fun createNewStaffAccount(newStaffRequest: AddNewStaffRequest) {
//        addStaff()
    }

    override fun addStaff(newStaff: Staff?) {
        staffRepository.save(newStaff)
    }

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

    override fun getExperiencedStaff(minExperience: Int): MutableList<Staff> =
        staffRepository.findAllByExperienceGreaterThan(minExperience)
}