package de.htw.VocLearner.web;

import de.htw.VocLearner.persistence.WortEntity;
import de.htw.VocLearner.service.UebersetzungService;
import de.htw.VocLearner.service.WordTranslationService;
import de.htw.VocLearner.service.WortService;
import de.htw.VocLearner.web.api.*;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

@RestController
public class TestRestController {

    @Autowired
    WortService wortService;
    @Autowired
    UebersetzungService uebersetzungService;
    @Autowired
    WordTranslationService wordTranslationService;

    public TestRestController(WortService wortService, UebersetzungService uebersetzungService) {
        this.wortService = wortService;
        this.uebersetzungService = uebersetzungService;
    }

    @GetMapping(path = "/api/v1/words")
    public ResponseEntity<List<Wort>> fetchWords() {
        return ResponseEntity.ok(wortService.findAll());
    }

    @GetMapping(path = "/api/v1/uebersetzungen")
    public ResponseEntity<List<Uebersetzung>> fetchUebersetzungen() {
        return ResponseEntity.ok(uebersetzungService.findAll());
    }

    @PostMapping(path = "/api/v1/words")
    public ResponseEntity<Void> createWord(@RequestBody WortManipulationRequest request) throws URISyntaxException {
        var wort = wortService.create(request);
        URI uri = new URI("/api/v1/words/" + wort.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/words/{id}")
    public ResponseEntity<Wort> fetchWordById(@PathVariable Long id) {
        var wort = wortService.findById(id);
        return wort != null ? ResponseEntity.ok(wort) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/words/{id}")
    public ResponseEntity<Wort> updateWort(@PathVariable Long id, @RequestBody WortManipulationRequest request) {
        var wort = wortService.update(id, request);
        return wort != null ? ResponseEntity.ok(wort) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/words/{id}")
    public ResponseEntity<Void> deleteWort(@PathVariable Long id) {
        boolean successful = wortService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/uebersetzungen")
    public ResponseEntity<Void> createUebersetzung(@RequestBody UebersetzungManipulationRequest request) throws URISyntaxException {
        var uebersetzung = uebersetzungService.create(request);
        URI uri = new URI("/api/v1/uebersetzungen/" + uebersetzung.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/uebersetzungen/{id}")
    public ResponseEntity<Uebersetzung> fetchUebersetzungById(@PathVariable Long id) {
        var uebersetzung = uebersetzungService.findById(id);
        return uebersetzung != null ? ResponseEntity.ok(uebersetzung) : ResponseEntity.notFound().build();
    }

    @PutMapping(path = "/api/v1/uebersetzungen/{id}")
    public ResponseEntity<Uebersetzung> updateUebersetzung(@PathVariable Long id, @RequestBody UebersetzungManipulationRequest request) {
        var uebersetzung = uebersetzungService.update(id, request);
        return uebersetzung != null ? ResponseEntity.ok(uebersetzung) : ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/api/v1/uebersetzungen/{id}")
    public ResponseEntity<Void> deleteUebersetzung(@PathVariable Long id) {
        boolean successful = uebersetzungService.deleteById(id);
        return successful ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }


    @PostMapping(path = "/api/v1/wordtranslation/add")
    public ResponseEntity<Wort> insertNewValues(@RequestBody WordTranslation wordTranslation){
        var newEntity = wordTranslationService.updateWordTranslation(wordTranslation);
        return newEntity != null ? ResponseEntity.ok(newEntity) : ResponseEntity.notFound().build();
    }

   @DeleteMapping(path ="/api/v1/wordtranslation/delete")
    public void removeWordAndTranslation(@RequestBody String word){
        wordTranslationService.deleteWordTranslation(word);
   }

}

