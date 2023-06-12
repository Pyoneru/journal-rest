package pl.piotrkniemczuk.journalrest.controller

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import pl.piotrkniemczuk.journalrest.model.DeleteOperationResult
import pl.piotrkniemczuk.journalrest.model.EntryDTO
import pl.piotrkniemczuk.journalrest.service.EntryService

@RestController
@RequestMapping("/api/entry")
class EntryController(
        val entryService: EntryService
){


    @GetMapping
    fun findAll(pageable: Pageable): List<EntryDTO> {
        return entryService.findAll(pageable)
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): EntryDTO {
        return entryService.findById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun save(@RequestBody input: EntryDTO): EntryDTO {
        return entryService.save(input)
    }

    @PutMapping("/{id}")
    fun update(@RequestBody input: EntryDTO, @PathVariable id: Long): EntryDTO {
        return entryService.update(input, id)
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): DeleteOperationResult {
        return entryService.deleteById(id)
    }
}