package pl.piotrkniemczuk.journalrest.model

data class ResponseError(
        val status: Int,
        val title: String,
        val message: String
)
