package de.htw.VocLearner.Services;


import de.htw.VocLearner.persistence.UebersetzungEntity;
import de.htw.VocLearner.persistence.UebersetzungRepository;
import de.htw.VocLearner.persistence.WortEntity;
import de.htw.VocLearner.persistence.WortRepository;
import de.htw.VocLearner.service.WordTranslationService;
import de.htw.VocLearner.web.api.WordTranslation;
import de.htw.VocLearner.web.api.Wort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;

@SpringBootTest
public class WordTranlationTest {

    @Autowired
    WordTranslationService wordTranslationService;

    @MockBean
    WortRepository wortRepository;

    @MockBean
    UebersetzungRepository uebersetzungRepository;

    @Test
    @DisplayName("test find all the words in database")
    void testData () {
        Set<UebersetzungEntity> uebersetzungEntities = new HashSet<>();
        Wort wort = new Wort(24L, "run", "english", uebersetzungEntities);
        List<Wort> allWorts = new ArrayList<>();
        allWorts.add(wort);

        WortEntity wortEntity =new WortEntity(24L, "run", "english", uebersetzungEntities);
        List<WortEntity> wortEntities = new ArrayList<>();
        wortEntities.add(wortEntity);

        when(wortRepository.findAll()).thenReturn(wortEntities);

        String expected = wordTranslationService.findAll().get(0).getBezeichnung();

        assertEquals(expected, "run");
    }


    @Test
    @DisplayName("test find word using name")
    void testFindByName () {
        Set<UebersetzungEntity> uebersetzungEntities = new HashSet<>();
        WortEntity wortEntity =new WortEntity(24L, "run", "english", uebersetzungEntities);

        when(wortRepository.findByName("run")).thenReturn(wortEntity);

        String expected = wordTranslationService.findUsingName("run").getBezeichnung();

        assertEquals(expected, "run");
    }
}
