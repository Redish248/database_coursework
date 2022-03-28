package itmo.coursework.model

import itmo.coursework.config.security.Role

data class NewUser(
    val username: String,
    val surname: String,
    val nick: String,
    val password: String,
    val email: String,
    val dateOfBirth: String,
    val gender: String,
    val role: Role = Role.READER
)