package itmo.coursework.model

import itmo.coursework.config.security.Role

data class AddStaffAccountRequest(
    val newStaff: AddStaffRequest,
    val userInfo: NewUserInfo
)

data class AddStaffRequest(
    val name: String,
    val surname: String,
    val patronymic: String,
    val gender: String,
    val dateOfBirth: String,
    val firstWorkDate: String,
    val positionUid: Long,
    val salary: Int,
    val experience: Int
)

data class NewUserInfo(
    val nick: String,
    val email: String,
    val password: String,
    val role: Role
)