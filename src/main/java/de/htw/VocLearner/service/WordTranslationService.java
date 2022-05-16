package de.htw.VocLearner.service;


import de.htw.VocLearner.persistence.UebersetzungEntity;
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
@NamedQuery(name = "WortEntity.deleteByName", query = "delete from Wort where bezeichnung = ?1")
public
class WordTranslationService {

    @Autowired
    WortRepository wortRepository;

    @Autowired
    UebersetzungService uebersetzungService;

    enum results{
        SUCCESS,
        NOT_SUCCESS
    }

    //insert word and its translation into database
    public WortEntity saveWordAndTranslation(WordTranslation wordTranslation){
        var wort = new WortEntity(wordTranslation.getWord(),wordTranslation.getLanguage());
        var translation = new UebersetzungEntity(wordTranslation.getTanslation(),wordTranslation.getTranLanguage(),1);
        wort.add(translation);
        return wortRepository.save(wort);

    }

    //delete the word und its transtaltions from our database
    public void deleteWordAndTranslation(Wort wort){
        wortRepository.deleteByName(wort.getBezeichnung());
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
