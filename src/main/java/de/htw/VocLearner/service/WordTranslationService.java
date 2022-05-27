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
import java.util.Set;
import java.util.stream.Collectors;

@Service

public
class WordTranslationService {

    @Autowired
    WortRepository wortRepository;


    @Autowired
    UebersetzungRepository uebersetzungRepository;


    public boolean checkWord(WordTranslation wordTranslation){
        if(wortRepository.findByName(wordTranslation.getWord()) == null) return true;
        else return false;
    }

    public boolean checkUebersetzung(WordTranslation wordTranslation){
        if(uebersetzungRepository.findByName(wordTranslation.getTranslation()) != null) return true;
        else return false;
    }

    public void deleteWordTranslation(String word){
        var helWortEntity = wortRepository.findByName(word);
        Set<UebersetzungEntity> uebersetzungEntities = helWortEntity.getUebersetzungEntities();
        for(UebersetzungEntity uebersetzungEntity : uebersetzungEntities){
            uebersetzungRepository.deleteById(uebersetzungEntity.getId());
        }

        wortRepository.deleteByName(word);
    }

    public Wort updateWordTranslation(WordTranslation wordTranslation){
        Wort returnedEntity = null;
        var wordEntity = wortRepository.findByName(wordTranslation.getWord());
        var uebersetzung = new UebersetzungEntity(wordTranslation.getTranslation(),wordTranslation.getTransLanguage(),1);
        if(checkWord(wordTranslation) == true) {
            wordEntity.add(uebersetzung);
            returnedEntity = transformEntity(wortRepository.save(wordEntity));

        }else{
            if(checkUebersetzung(wordTranslation) == false){
                var helpEntity = wordEntity;
                helpEntity.add(uebersetzung);
                for(UebersetzungEntity uebersetzungEntity : wordEntity.getUebersetzungEntities()){
                    uebersetzungRepository.delete(uebersetzungEntity);
                }
                wortRepository.delete(wordEntity);
                returnedEntity = transformEntity(wortRepository.save(helpEntity));
            }
        }
        return returnedEntity;
    }


    private Wort transformEntity(WortEntity wortEntity) {
        return new Wort(
                wortEntity.getId(),
                wortEntity.getBezeichnung(),
                wortEntity.getSprache(),
                wortEntity.getUebersetzungEntities()
        );
    }


}
