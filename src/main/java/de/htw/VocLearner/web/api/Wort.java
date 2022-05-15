package de.htw.VocLearner.web.api;

public class Wort {

    private long id;
    private String bezeichnung;
    private String sprache;

    public Wort(long id, String bezeichnung, String sprache) {
        this.id = id;
        this.bezeichnung = bezeichnung;
        this.sprache = sprache;
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
}
