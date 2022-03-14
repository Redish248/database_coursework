package itmo.coursework.model

data class NewUser(
    val username: String,
    val surname: String,
    val nick: String,
    val password: String,
    val email: String,
    val dateOfBirth: String,
    val gender: String
)