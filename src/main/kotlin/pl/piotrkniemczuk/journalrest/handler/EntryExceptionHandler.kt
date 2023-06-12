package pl.piotrkniemczuk.journalrest.handler

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import pl.piotrkniemczuk.journalrest.model.ResponseError

import pl.piotrkniemczuk.journalrest.service.exception.EntryNotFoundException

@ControllerAdvice
class EntryExceptionHandler {

    @ExceptionHandler(EntryNotFoundException::class)
    fun handleEntryNotFoundException(e: EntryNotFoundException): ResponseEntity<ResponseError> {
        return ResponseEntity(ResponseError(
                HttpStatus.NOT_FOUND.value(),
                "entry-not-found",
                "Cannot find entry with given ID."

        ), HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler(Exception::class)
    fun handleGlobalException(e: Exception): ResponseEntity<ResponseError> {
        return ResponseEntity.badRequest().body(
                ResponseError(
                        HttpStatus.BAD_REQUEST.value(),
                        "unknown-error",
                        e.message + "\n" + e.stackTrace
                )
        )
    }
}