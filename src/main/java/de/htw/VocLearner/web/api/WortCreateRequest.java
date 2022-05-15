package de.htw.VocLearner.web.api;

public class WortCreateRequest {

    private String bezeichnung;

    public WortCreateRequest(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

}
