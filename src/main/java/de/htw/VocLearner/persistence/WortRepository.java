package de.htw.VocLearner.persistence;

import de.htw.VocLearner.web.api.Wort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WortRepository extends JpaRepository<WortEntity, Long> {
    void deleteByName(String word);
}
