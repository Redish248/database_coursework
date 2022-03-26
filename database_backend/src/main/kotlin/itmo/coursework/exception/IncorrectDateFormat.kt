package itmo.coursework.exception

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.BAD_REQUEST)
class IncorrectDateFormat(inputDate: String) : CourseWorkException("Can't parse date $inputDate. Wait dd/MM/yyyy")