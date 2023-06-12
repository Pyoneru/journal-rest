package pl.piotrkniemczuk.journalrest.service.simple

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import pl.piotrkniemczuk.journalrest.model.DeleteOperationResult
import pl.piotrkniemczuk.journalrest.model.EntryDTO
import pl.piotrkniemczuk.journalrest.repository.EntryRepository
import pl.piotrkniemczuk.journalrest.service.EntryService
import pl.piotrkniemczuk.journalrest.service.exception.EntryNotFoundException
import pl.piotrkniemczuk.journalrest.service.mapper.EntryMapper

@Service
class SimpleEntryService(
        val entryRepository: EntryRepository,
        val entryMapper: EntryMapper
) : EntryService {

    override fun save(input: EntryDTO): EntryDTO {
        input.id = null
        input.createdAt = null

        val entity = entryMapper.toEntity(input)
        val saved = entryRepository.save(entity)

        return entryMapper.toDTO(saved)
    }

    override fun update(input: EntryDTO, id: Long): EntryDTO {
        val oEntry = entryRepository.findById(id)

        if(oEntry.isPresent){
            val entity = oEntry.get()
            // No validation, possible error
            entity.title = input.title
            entity.content = input.content

            val saved = entryRepository.save(entity)
            return entryMapper.toDTO(saved)
        }else{
            throw EntryNotFoundException()
        }
    }

    override fun findAll(pageable: Pageable): List<EntryDTO> {
        return entryRepository.findAll(pageable).content.map(entryMapper::toDTO)
    }

    override fun findById(id: Long): EntryDTO {
        return entryMapper.toDTO(
                entryRepository.findById(id).orElseThrow{EntryNotFoundException()}
        )
    }

    override fun deleteById(id: Long): DeleteOperationResult {
        val exists = entryRepository.existsById(id)
        return if(exists){
            entryRepository.deleteById(id)
            DeleteOperationResult(true)
        }else{
            DeleteOperationResult(false)
        }
    }
}