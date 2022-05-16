package de.htw.VocLearner.persistence;

import de.htw.VocLearner.web.api.Wort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.NamedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WortRepository extends JpaRepository<WortEntity, Long> {
    @Transactional
    @Modifying
    @Query("delete from Wort where bezeichnung = ?1")
    void deleteByName(String word);
}
