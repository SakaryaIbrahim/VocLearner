package de.htw.VocLearner.persistence;

import javax.persistence.*;

@Entity(name = "Wort")
public class WortEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bezeichnung", nullable = false)
    private String bezeichnung;

    @Column(name = "sprache", nullable = false)
    private String sprache;

   public WortEntity(String bezeichnung) {
        this.bezeichnung = bezeichnung;
        this.sprache = sprache;
    }

    protected WortEntity(){
    }

    public Long getId() {
        return id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getSprache() { return sprache; }

    public void setSprache(String sprache) { this.sprache = sprache; }
}