package de.htw.VocLearner.web;

import de.htw.VocLearner.service.WordTranslationService;
import de.htw.VocLearner.web.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.support.ResourcePropertiesPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TestRestController {

    @Autowired
    WordTranslationService wordTranslationService;


    @GetMapping(path = "/api/v1/words")
    public ResponseEntity<List<Wort>> fetchWords() {
        return ResponseEntity.ok(wordTranslationService.findAll());
    }

    @GetMapping(path = "/api/v1/words/{id}")
    public ResponseEntity<Wort> fetchWordById(@PathVariable Long id) {
        var wort = wordTranslationService.findById(id);
        return wort != null ? ResponseEntity.ok(wort) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/wordtranslation")
    public ResponseEntity<Wort> insertNewValues(@RequestBody WordTranslation wordTranslation){
        var newEntity = wordTranslationService.insertWordTranslation(wordTranslation);
        return newEntity != null ? ResponseEntity.ok(newEntity) : ResponseEntity.notFound().build();
    }

   @DeleteMapping(path ="/api/v1/wordtranslation")
    public void removeWordAndTranslation(@RequestBody String word){
        wordTranslationService.deleteWordTranslation(word);
   }

   @PostMapping(path = "api/v1/uebersetzung")
    public ResponseEntity<Uebersetzung> updateWahrscheinlichkeit(@RequestBody Wort wort){
        return ResponseEntity.ok(wordTranslationService.updateProbability(wort));
   }

}

