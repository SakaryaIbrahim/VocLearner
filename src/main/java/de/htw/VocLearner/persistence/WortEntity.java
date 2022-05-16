package de.htw.VocLearner.persistence;

import de.htw.VocLearner.web.api.Uebersetzung;
import jdk.jfr.Name;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    @JoinColumn(name = "wortEntity_id",referencedColumnName = "id")
    private Set<UebersetzungEntity> uebersetzungEntities = new HashSet<>();


   public WortEntity(String bezeichnung, String sprache) {
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

    public Set<UebersetzungEntity> getUebersetzungEntities() {
        return uebersetzungEntities;
    }

    public void setUebersetzungEntities(Set<UebersetzungEntity> uebersetzungEntities) {
        this.uebersetzungEntities = uebersetzungEntities;
    }

    public void add(UebersetzungEntity uebersetzungEntity){
       if(!uebersetzungEntities.contains(uebersetzungEntity)) uebersetzungEntities.add(uebersetzungEntity);
    }
}