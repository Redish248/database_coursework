package itmo.coursework.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
open class CourseWorkException(message: String) : RuntimeException(message)
