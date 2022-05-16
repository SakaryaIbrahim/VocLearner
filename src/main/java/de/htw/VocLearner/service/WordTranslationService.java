package de.htw.VocLearner.service;


import de.htw.VocLearner.persistence.UebersetzungEntity;
import de.htw.VocLearner.persistence.UebersetzungRepository;
import de.htw.VocLearner.persistence.WortEntity;
import de.htw.VocLearner.persistence.WortRepository;
import de.htw.VocLearner.web.api.Uebersetzung;
import de.htw.VocLearner.web.api.WordTranslation;
import de.htw.VocLearner.web.api.Wort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service

public
class WordTranslationService {

    private final WortRepository wortRepository;

    public WordTranslationService(WortRepository wortRepository) {
        this.wortRepository = wortRepository;
    }


    //insert word and its translation into database
    public WortEntity saveWordAndTranslation(WordTranslation wordTranslation){
        var wort = new WortEntity(wordTranslation.getWord(),wordTranslation.getLanguage());
        var translation = new UebersetzungEntity(wordTranslation.getTranslation(),wordTranslation.getTransLanguage(),1.0f);
        wort.add(translation);
        return wortRepository.save(wort);

    }

    //delete the word und its transtaltions from our database
    public void deleteWordAndTranslation(String wort){
        wortRepository.deleteByName(wort);
    }

    //fetch ten words and their translation
    public List<Wort> fetchWordsFromDatabase(int factor) {
        List<WortEntity> WordsForGame = wortRepository.findAll();
        return WordsForGame.stream()
                .map(this::transformEntity).
                collect(Collectors.toList());
    }

    private Wort transformEntity(WortEntity wortEntity) {
        return new Wort(
                wortEntity.getId(),
                wortEntity.getBezeichnung(),
                wortEntity.getSprache()
        );
    }
}
