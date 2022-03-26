package itmo.coursework.service

import itmo.coursework.entity.statistic.Position
import itmo.coursework.entity.statistic.Staff
import itmo.coursework.exception.PositionNotFoundException
import itmo.coursework.exception.StaffNotFoundException
import itmo.coursework.model.AddNewStaffRequest
import itmo.coursework.model.UpdateStaffRequest
import itmo.coursework.parseStringToSqlDate
import itmo.coursework.repository.statistic.PositionRepository
import itmo.coursework.repository.statistic.StaffRepository
import org.springframework.stereotype.Service

@Service
class StaffServiceImpl(
    private val staffRepository: StaffRepository,
    private val positionRepository: PositionRepository
) : StaffService {

    override fun getStaff(): List<Staff> {
        return staffRepository.findAll()
    }

    override fun getPositionByUid(uid: Long): Position =
        positionRepository.findPositionByUid(uid) ?: throw PositionNotFoundException(uid)

    override fun getPositions(): List<Position> {
        return positionRepository.findAll()
    }

    fun createNewStaffAccount(newStaffRequest: AddNewStaffRequest) = with(newStaffRequest) {
        println("create new staff $newStaffRequest")
        saveStaff(
            Staff(
                name,
                surname,
                patronymic,
                parseStringToSqlDate(dateOfBirth),
                gender,
                getPositionByUid(positionUid),
                salary,
                experience,
                parseStringToSqlDate(firstWorkDate)

            )
        )
    }

    fun updateStaffAccount(staffUid: Long, request: UpdateStaffRequest) = with(getStaffByUid(staffUid)) {
        println("update staff $request")
        saveStaff(
            Staff(
                request.name ?: name,
                request.surname ?: surname,
                request.patronymic ?: patronymic,
                parseStringToSqlDate(request.dateOfBirth) ?: this.dateOfBirth,
                request.gender ?: gender,
                request.positionUid?.let { getPositionByUid(it) } ?: positionType,
                request.salary ?: salary,
                request.experience ?: experience,
                parseStringToSqlDate(request.firstWorkDate) ?: firstWorkDate
            )
        )
    }

    override fun saveStaff(newStaff: Staff?) {
        staffRepository.save(newStaff)
    }

    override fun getPositionByName(name: String?): List<Position> = positionRepository.findPositionByName(name)

    override fun getStaffByUid(uid: Long): Staff =
        staffRepository.findStaffByUid(uid) ?: throw StaffNotFoundException(uid)

    override fun getStaffByNameAndSurname(name: String?, surname: String?): List<Staff> =
        staffRepository.findStaffByNameAndSurname(name, surname)

    override fun getStaffBySurname(surname: String?): List<Staff> = staffRepository.findStaffBySurname(surname)

    override fun getStaffByGender(gender: String?): List<Staff> = staffRepository.findStaffByGender(gender)

    override fun getStaffByPositionType(position: Position): List<Staff> =
        staffRepository.findStaffByPositionType(position)

    override fun getStaffBySalaryGreaterThan(minSalary: Int): List<Staff> =
        staffRepository.findStaffBySalaryGreaterThan(minSalary)

    override fun getStaffBySalaryLessThan(maxSalary: Int): List<Staff> =
        staffRepository.findStaffBySalaryLessThan(maxSalary)

    override fun getExperiencedStaff(minExperience: Int): List<Staff> =
        staffRepository.findAllByExperienceGreaterThan(minExperience)
}