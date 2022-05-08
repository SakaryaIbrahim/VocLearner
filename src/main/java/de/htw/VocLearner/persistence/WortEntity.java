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

   public WortEntity(Long id, String bezeichnung) {
        this.id = id;
        this.bezeichnung = bezeichnung;
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

}