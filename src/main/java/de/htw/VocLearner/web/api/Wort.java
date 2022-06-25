package de.htw.VocLearner.web.api;

import de.htw.VocLearner.persistence.UebersetzungEntity;

import java.util.HashSet;
import java.util.Set;

public class Wort {

    private long id;
    private String bezeichnung;
    private String sprache;

    private Set<UebersetzungEntity> uebersetzungSet = new HashSet<>();

    public Wort(long id, String bezeichnung, String sprache,Set<UebersetzungEntity> uebersetzungSet) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.sprache = sprache;
        this.uebersetzungSet = uebersetzungSet;
    }

    public Wort(){

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public Set<UebersetzungEntity> getUebersetzungSet() {
        return uebersetzungSet;
    }

    public void setUebersetzungSet(Set<UebersetzungEntity> uebersetzungSet) {
        this.uebersetzungSet = uebersetzungSet;
    }
}
