package itmo.coursework

import itmo.coursework.config.security.Role
import itmo.coursework.entity.statistic.Users
import itmo.coursework.model.NewUser
import itmo.coursework.service.RegistrationService
import itmo.coursework.service.StaffService
import itmo.coursework.service.UserService
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
@Disabled("run ones to fill data")
class CreateUsers {
    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var registrationService: RegistrationService

    @Autowired
    private lateinit var staffService: StaffService

    data class Account(
        val nick: String,
        val role: Role = Role.READER
    )

    @Test
    fun createDefaultUsers() {
        registrationService.registerNewUser(
            NewUser(
                "admin",
                "admin",
                "admin",
                "admin",
                "admin@silverpaw.ru",
                "2022.02.01",
                "женский",
                Role.ADMIN
            )
        )
        registrationService.registerNewUser(
            NewUser(
                "manager",
                "manager",
                "manager",
                "manager",
                "manager@silverpaw.ru",
                "2022.02.01",
                "женский",
                Role.MANAGER
            )
        )
        registrationService.registerNewUser(
            NewUser(
                "user",
                "user",
                "user",
                "user",
                "user@silverpaw.ru",
                "2022.02.01",
                "женский",
                Role.READER
            )
        )
        Assertions.assertTrue { true }
    }

    @Test
    fun createUsers() {
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