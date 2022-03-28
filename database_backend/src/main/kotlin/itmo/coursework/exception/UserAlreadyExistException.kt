package itmo.coursework.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class UserAlreadyExistException(nick: String) : CourseWorkException("Illegal nick $nick")