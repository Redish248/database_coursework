package itmo.coursework.config.security

public val rolesToPermissionsMap = mapOf(
    Role.READER to listOf(Permission.READ),
    Role.MANAGER to listOf(Permission.MANAGE_ANIMALS, Permission.READ),
    Role.ADMIN to listOf(Permission.ADMINISTRATION, Permission.MANAGE_ANIMALS, Permission.READ),
)

enum class Permission {
    READ,
    MANAGE_ANIMALS,
    ADMINISTRATION
}

enum class Role {
    ADMIN,
    MANAGER,
    READER
}