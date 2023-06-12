package pl.piotrkniemczuk.journalrest.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter

@Configuration
class GlobalConfig {

    @Bean
    fun dateFormat(): SimpleDateFormat = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")

}