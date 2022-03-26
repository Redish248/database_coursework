package itmo.coursework.model

import java.util.Date

data class AddNewStaffRequest(
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