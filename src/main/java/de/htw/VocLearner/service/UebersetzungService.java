package de.htw.VocLearner.service;

import de.htw.VocLearner.persistence.UebersetzungEntity;
import de.htw.VocLearner.persistence.UebersetzungRepository;
import de.htw.VocLearner.web.api.Uebersetzung;
import de.htw.VocLearner.web.api.UebersetzungManipulationRequest;
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

    public Uebersetzung create(UebersetzungManipulationRequest request) {
        var uebersetzungEntity = new UebersetzungEntity(request.getUebersetzung(), request.getWort_Fk(),
                request.getSprache(), request.getWahrscheinlichkeit());
        uebersetzungEntity = uebersetzungRepository.save(uebersetzungEntity);
        return transformEntity(uebersetzungEntity);
    }

    public Uebersetzung update(Long id, UebersetzungManipulationRequest request) {
        var uebersetzungEntityOptional = uebersetzungRepository.findById(id);
        if (uebersetzungEntityOptional.isEmpty()) {
            return null;
        }
        var uebersetzungEntity = uebersetzungEntityOptional.get();
        uebersetzungEntity.setUebersetzung(request.getUebersetzung());
        uebersetzungEntity.setSprache(request.getSprache());
        uebersetzungEntity.setWahrscheinlichkeit(request.getWahrscheinlichkeit());
        uebersetzungEntity.setWort_Fk(request.getWort_Fk());
        uebersetzungEntity = uebersetzungRepository.save(uebersetzungEntity);
        return transformEntity(uebersetzungEntity);
    }

    public boolean deleteById(Long id) {
        if (!uebersetzungRepository.existsById(id)) {
            return false;
        }
        uebersetzungRepository.deleteById(id);
        return true;
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