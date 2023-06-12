package pl.piotrkniemczuk.journalrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.piotrkniemczuk.journalrest.model.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {

}
