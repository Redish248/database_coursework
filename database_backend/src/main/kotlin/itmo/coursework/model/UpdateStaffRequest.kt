package itmo.coursework.model

data class UpdateStaffRequest(
    val name: String?,
    val surname: String?,
    val patronymic: String?,
    val gender: String?,
    val dateOfBirth: String?,
    val firstWorkDate: String?,
    val positionUid: Long?,
    val salary: Int?,
    val experience: Int?
)