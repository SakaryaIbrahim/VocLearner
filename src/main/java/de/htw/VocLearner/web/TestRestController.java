package de.htw.VocLearner.web;

import de.htw.VocLearner.persistence.UebersetzungRepository;
import de.htw.VocLearner.persistence.WortEntity;
import de.htw.VocLearner.service.UebersetzungService;
import de.htw.VocLearner.service.WortService;
import de.htw.VocLearner.web.api.Uebersetzung;
import de.htw.VocLearner.web.api.UebersetzungCreateRequest;
import de.htw.VocLearner.web.api.Wort;
import de.htw.VocLearner.web.api.WortCreateRequest;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class TestRestController {

    @Autowired
    WortService wortService;
    @Autowired
    UebersetzungService uebersetzungService;

    public TestRestController(WortService wortService, UebersetzungService uebersetzungService) {
        this.wortService = wortService;
        this.uebersetzungService = uebersetzungService;
    }

    @GetMapping(path = "/api/v1/words")
    public ResponseEntity<List<Wort>> fetchWords() {
        return ResponseEntity.ok(wortService.findAll());
    }

    @GetMapping(path = "/api/v1/uebersetzungen")
    public ResponseEntity<List<Uebersetzung>> fetchUebersetzungen(){ return ResponseEntity.ok(uebersetzungService.findAll()); }

    @PostMapping(path = "/api/v1/words")
    public ResponseEntity<Void> createWord(@RequestBody WortCreateRequest request) throws URISyntaxException {
        var wort = wortService.create(request);
        URI uri = new URI("/api/v1/words/" + wort.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/words/{id}")
    public ResponseEntity<Wort> fetchWordById(@PathVariable Long id) {
        var wort = wortService.findById(id);
        return wort != null? ResponseEntity.ok(wort) : ResponseEntity.notFound().build();
    }

    @PostMapping(path = "/api/v1/uebersetzungen")
    public ResponseEntity<Void> createUebersetzung(@RequestBody UebersetzungCreateRequest request) throws URISyntaxException {
        var uebersetzung = uebersetzungService.create(request);
        URI uri = new URI("/api/v1/uebersetzungen/" + uebersetzung.getId());
        return ResponseEntity.created(uri).build();
    }

    @GetMapping(path = "/api/v1/uebersetzungen/{id}")
    public ResponseEntity<Uebersetzung> fetchUebersetzungById(@PathVariable Long id) {
        var uebersetzung = uebersetzungService.findById(id);
        return uebersetzung != null? ResponseEntity.ok(uebersetzung) : ResponseEntity.notFound().build();
    }

}

