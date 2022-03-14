package itmo.coursework.model

import java.util.Date

data class AddNewStaffRequest(
    val name: String,
    val surname: String,
    val patronymic: String,
    val gender: String,
//    val birthday: Date,
//    val firstWorkDate: Date = today
    val positionType: Int,
    val salary: Int,
    val experience: Int

)