package itmo.coursework.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class StaffNotFoundException(uid: Long) : CourseWorkException("Staff with uid $uid not found")