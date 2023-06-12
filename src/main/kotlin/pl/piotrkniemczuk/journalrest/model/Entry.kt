package pl.piotrkniemczuk.journalrest.model

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Lob
import java.util.Date

@Entity
class Entry(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long?,
        var title: String,
        @Column(columnDefinition = "TEXT")
        var content: String,
        val createdAt: Date
)