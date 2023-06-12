package pl.piotrkniemczuk.journalrest.service.mapper

import org.springframework.stereotype.Component
import java.text.SimpleDateFormat
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Date

@Component
class DateMapper(
        private val dateFormat: SimpleDateFormat,
) {

    fun toDate(date: String): Date = dateFormat.parse(date)

    fun toString(date: Date): String = dateFormat.format(date)
}