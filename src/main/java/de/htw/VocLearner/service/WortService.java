package de.htw.VocLearner.service;

import de.htw.VocLearner.persistence.WortEntity;
import de.htw.VocLearner.persistence.WortRepository;
import de.htw.VocLearner.web.api.Uebersetzung;
import de.htw.VocLearner.web.api.UebersetzungManipulationRequest;
import de.htw.VocLearner.web.api.Wort;
import de.htw.VocLearner.web.api.WortManipulationRequest;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class WortService {

    private final WortRepository wortRepository;

    public WortService(WortRepository wortRepository) {
        this.wortRepository = wortRepository;
    }

    public List<Wort> findAll() {
        List<WortEntity> words = wortRepository.findAll();
        return words.stream()
                .map(this::transformEntity)
                .collect(Collectors.toList());
    }

    public Wort findById(Long id) {
        var wortEntity = wortRepository.findById(id);
        return wortEntity.map(this::transformEntity).orElse(null);
    }

    public Wort create(WortManipulationRequest request) {
        var wortEntity = new WortEntity(request.getBezeichnung(), request.getSprache());
        wortEntity = wortRepository.save(wortEntity);
        return transformEntity(wortEntity);
    }

    public Wort update(Long id, WortManipulationRequest request) {
        var wortEntityOptional = wortRepository.findById(id);
        if (wortEntityOptional.isEmpty()) {
            return null;
        }
        var wortEntity = wortEntityOptional.get();
        wortEntity.setBezeichnung(request.getBezeichnung());
        wortEntity.setSprache(request.getSprache());
        return transformEntity(wortEntity);
    }

    public boolean deleteById(Long id) {
        if (!wortRepository.existsById(id)) {
            return false;
        }
        wortRepository.deleteById(id);
        return true;
    }

    private Wort transformEntity(WortEntity wortEntity) {
        return new Wort(
                wortEntity.getId(),
                wortEntity.getBezeichnung(),
                wortEntity.getSprache()
        );
    }
}

