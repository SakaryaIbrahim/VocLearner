package de.htw.VocLearner.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UebersetzungRepository extends JpaRepository<UebersetzungEntity, Long> {

}
