package de.htw.VocLearner.web;

import de.htw.VocLearner.web.api.Uebersetzung;
import de.htw.VocLearner.web.api.Wort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TestRestController {

    private List<Wort> words;
    private List<Uebersetzung> uebersetzungen;

    public TestRestController() {
        words = new ArrayList<>();
        uebersetzungen = new ArrayList<>();
        words.add(new Wort(1, "laufen"));
        words.add(new Wort(2, "schreiben"));
        uebersetzungen.add(new Uebersetzung(1, "walk", 1, "Englisch", 1f ));
        uebersetzungen.add(new Uebersetzung(2, "ir", 1, "Spanisch", 1f ));
        uebersetzungen.add(new Uebersetzung(3, "write", 2, "Englisch", 1f ));
    }

    @GetMapping(path = "/api/v1/words")
    public ResponseEntity<List<Wort>> fetchWords() {
        return ResponseEntity.ok(words);
    }

    @GetMapping(path = "/api/v1/uebersetzungen")
    public ResponseEntity<List<Uebersetzung>> fetchUebersetzungen(){ return ResponseEntity.ok(uebersetzungen); }
}

