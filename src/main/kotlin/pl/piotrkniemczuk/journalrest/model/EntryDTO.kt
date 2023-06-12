package pl.piotrkniemczuk.journalrest.model

import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

data class EntryDTO(
        @JsonInclude(JsonInclude.Include.NON_NULL)
        var id: Long?,
        var title: String,
        var content: String,
        @JsonInclude(JsonInclude.Include.NON_NULL)
        var createdAt: String?
)