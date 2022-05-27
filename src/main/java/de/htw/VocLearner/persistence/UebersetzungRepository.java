package de.htw.VocLearner.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UebersetzungRepository extends JpaRepository<UebersetzungEntity, Long> {

    @Query(value = "select id,sprache,uebersetzung,wahrscheinlichkeit from Uebersetzung where uebersetzung=?1",nativeQuery = true)
    UebersetzungEntity findByName(String word);
}
