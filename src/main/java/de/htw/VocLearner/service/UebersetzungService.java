package de.htw.VocLearner.service;

import de.htw.VocLearner.persistence.UebersetzungEntity;
import de.htw.VocLearner.persistence.UebersetzungRepository;
import de.htw.VocLearner.persistence.WortEntity;
import de.htw.VocLearner.web.api.Uebersetzung;
import de.htw.VocLearner.web.api.UebersetzungCreateRequest;
import de.htw.VocLearner.web.api.Wort;
import de.htw.VocLearner.web.api.WortCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UebersetzungService {

    private final UebersetzungRepository uebersetzungRepository;

    public UebersetzungService(UebersetzungRepository uebersetzungRepository) {
        this.uebersetzungRepository = uebersetzungRepository;
    }

    public List<Uebersetzung> findAll() {
        List<UebersetzungEntity> uebersetzungen = uebersetzungRepository.findAll();
        return uebersetzungen.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Uebersetzung findById(Long id) {
        var uebersetzungEntity = uebersetzungRepository.findById(id);
        return uebersetzungEntity.map(this::transformEntity).orElse(null);
    }

    public Uebersetzung create(UebersetzungCreateRequest request) {
        var uebersetzungEntity = new UebersetzungEntity(request.getUebersetzung(), request.getWort_Fk(),
                request.getSprache(), request.getWahrscheinlichkeit());
        uebersetzungEntity = uebersetzungRepository.save(uebersetzungEntity);
        return transformEntity(uebersetzungEntity);
    }

    private Uebersetzung transformEntity(UebersetzungEntity uebersetzungEntity) {
        return new Uebersetzung(
                uebersetzungEntity.getId(),
                uebersetzungEntity.getUebersetzung(),
                uebersetzungEntity.getWort_Fk(),
                uebersetzungEntity.getSprache(),
                uebersetzungEntity.getWahrscheinlichkeit()
        );
    }
}
