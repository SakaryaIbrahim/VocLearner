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


    public WortEntity findUsingName (String word){
        return wortRepository.findByName(word);
    }

    public String deleteWordTranslation(String word){
        var helWortEntity = findUsingName(word);

        if(helWortEntity != null){
            Set<UebersetzungEntity> uebersetzungEntities = helWortEntity.getUebersetzungEntities();
            for(UebersetzungEntity uebersetzungEntity : uebersetzungEntities){
                uebersetzungRepository.deleteById(uebersetzungEntity.getId());
            }

            wortRepository.deleteByName(word);
        }
        return "SUCESS";
    }

    public Wort insertWordTranslation(WordTranslation wordTranslation){
        Wort returnedEnity = null;
        var wordEntity = wortRepository.findByName(wordTranslation.getWord());
        var uebersetzung = new UebersetzungEntity(wordTranslation.getTranslation(),wordTranslation.getTransLanguage(),1);

        if(wordEntity == null){
            wordEntity = new WortEntity(wordTranslation.getWord(),wordTranslation.getLanguage());
            wordEntity.add(uebersetzung);
            wortRepository.save(wordEntity);
            returnedEnity = transformEntity(wordEntity);
        }else{
            if(wordEntity.getUebersetzungEntities().contains(uebersetzung)){

            }else{
            wordEntity.add(uebersetzung);
            wortRepository.save(wordEntity);
            returnedEnity = transformEntity(wordEntity);
            }
        }
        return returnedEnity;
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

    public Wort updateProbability(Wort wort){
        for(UebersetzungEntity uebersetzungEntity: wort.getUebersetzungSet()){
            uebersetzungRepository.updateWahrscheinlichkeitById(uebersetzungEntity.getWahrscheinlichkeit(), uebersetzungEntity.getId());
        }

        return wort;
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
