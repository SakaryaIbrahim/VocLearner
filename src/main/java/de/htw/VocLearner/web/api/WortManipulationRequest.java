package de.htw.VocLearner.web.api;

public class WortManipulationRequest {

    private String bezeichnung;
    private String sprache;

    public WortManipulationRequest(String bezeichnung, String sprache) {
        this.bezeichnung = bezeichnung;
        this.sprache = sprache;
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
