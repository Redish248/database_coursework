package itmo.coursework.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class PositionNotFoundException(positionUid: Long) : CourseWorkException("Position #$positionUid not found")