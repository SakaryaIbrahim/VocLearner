package de.htw.VocLearner.web.api;

public class Wort {

    private long id;
    private String bezeichnung;

    public Wort(long id, String bezeichnung) {
        this.id = id;
        this.bezeichnung = bezeichnung;
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

}
