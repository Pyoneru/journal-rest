package pl.piotrkniemczuk.journalrest.service.mapper

import org.springframework.stereotype.Component
import pl.piotrkniemczuk.journalrest.model.Entry
import pl.piotrkniemczuk.journalrest.model.EntryDTO
import pl.piotrkniemczuk.journalrest.util.Utils

@Component
class EntryMapper(
        private val dateMapper: DateMapper
) {

    fun toEntity(dto: EntryDTO): Entry = Entry(
            id = dto.id,
            title = dto.title,
            content = dto.content,
            createdAt = if(dto.createdAt != null) dateMapper.toDate(dto.createdAt!!) else Utils.now()
    )

    fun toDTO(entity: Entry): EntryDTO = EntryDTO(
            id = entity.id,
            title = entity.title,
            content = entity.content,
            createdAt = dateMapper.toString(entity.createdAt)
    )
}