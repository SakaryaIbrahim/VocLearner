package de.htw.VocLearner.persistence;

import de.htw.VocLearner.web.api.Uebersetzung;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface UebersetzungRepository extends JpaRepository<UebersetzungEntity, Long> {

    @Query(value = "select id,sprache,uebersetzung,wahrscheinlichkeit from Uebersetzung where uebersetzung=?1",nativeQuery = true)
    UebersetzungEntity findByName(String word);

    @Modifying
    @Transactional
    @Query(value = "update Uebersetzung set wahrscheinlichkeit = ?1 where id=?2")
    void updateWahrscheinlichkeitById(float prob, long id);
}
