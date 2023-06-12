package pl.piotrkniemczuk.journalrest.service

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import pl.piotrkniemczuk.journalrest.model.DeleteOperationResult
import pl.piotrkniemczuk.journalrest.model.EntryDTO

interface EntryService {

    fun save(input: EntryDTO): EntryDTO

    fun update(input: EntryDTO, id: Long): EntryDTO

    fun findAll(pageable: Pageable): List<EntryDTO>

    fun findById(id: Long): EntryDTO

    fun deleteById(id: Long): DeleteOperationResult
}