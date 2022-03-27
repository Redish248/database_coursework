package itmo.coursework

import itmo.coursework.exception.IncorrectDateFormat
import java.sql.Date
import java.text.SimpleDateFormat

fun parseStringToSqlDate(date: String?): Date? {
    if (date == null) return null
    try {
        val format = SimpleDateFormat("dd.MM.yyyy")
        val parsed = format.parse(date)
        return Date(parsed.time)
    } catch (e: Exception) {
        throw IncorrectDateFormat(date)
    }
}