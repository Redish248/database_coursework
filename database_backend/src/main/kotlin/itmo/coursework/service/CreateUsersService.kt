package itmo.coursework.service

import itmo.coursework.config.security.Role
import itmo.coursework.entity.statistic.Users
import itmo.coursework.parseStringToSqlDate
import org.springframework.stereotype.Service

// todo - delete after use
@Service
class CreateUsersService(
    private val staffService: StaffService,
    private val userService: UserService
) {

    fun createUsers() {
        createDefaultUsers()
        createStaffUsers()
    }

    data class Account(
        val nick: String,
        val role: Role = Role.READER
    )

    private fun createDefaultUsers() {
        userService.createUser(
            Users(
                "admin",
                "admin",
                parseStringToSqlDate("2022.02.01"),
                "женский",
                "admin",
                "admin@silverpaw.ru",
                "admin",
                userService.getUserTypesByName(Role.ADMIN.name).first()
            )
        )
        userService.createUser(
            Users(
                "manager",
                "manager",
                parseStringToSqlDate("2022.02.01"),
                "женский",
                "manager",
                "manager@silverpaw.ru",
                "manager",
                userService.getUserTypesByName(Role.MANAGER.name).first()
            )
        )
        userService.createUser(
            Users(
                "user",
                "user",
                parseStringToSqlDate("2022.02.01"),
                "женский",
                "user",
                "user@silverpaw.ru",
                "user",
                userService.getUserTypesByName(Role.READER.name).first()
            )
        )
    }

    private fun createStaffUsers() {
        val staff = staffService.staff
        val map = mapOf(
            "Сидоров Илья" to Account("gen_dir", Role.ADMIN),
            "Прокатьева Юлия" to Account("main_vet"),
            "Кузьмина Илона" to Account("vet"),
            "Васильева Ульяна" to Account("lawyer"),
            "Петрова Марьяна" to Account("main_accountant"),
            "Песков Олег" to Account("accountant"),
            "Окатьев Евгений" to Account("volunteer_1", Role.MANAGER),
            "Культов Александр" to Account("volunteer_2", Role.MANAGER),
            "Михайлов Игорь" to Account("volunteer_3", Role.MANAGER),
            "Прокофьев Иван" to Account("feed_1"),
            "Бобченко Владислав" to Account("feed_2"),
            "Спиридонов Артем" to Account("feed_3"),
            "Васильева Мария" to Account("marketer")
        )
        staff.forEach {
            val account = map["${it.surname} ${it.name}"]
            if (account != null) {
                userService.createUser(
                    Users(
                        it.name,
                        it.surname,
                        it.dateOfBirth,
                        it.gender,
                        account.nick,
                        "${account.nick}@silverpaw.ru",
                        account.nick,
                        userService.getUserTypesByName(account.role.name).first()
                    )
                )
            }
        }
    }


}