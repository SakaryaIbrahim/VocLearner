package de.htw.VocLearner.web.api;

public class WortManipulationRequest {

    private String bezeichnung;

    public WortManipulationRequest(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }

    public void setBezeichnung(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

}
