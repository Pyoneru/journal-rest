package pl.piotrkniemczuk.journalrest

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JournalRestApplication

fun main(args: Array<String>) {
    runApplication<JournalRestApplication>(*args)
}
