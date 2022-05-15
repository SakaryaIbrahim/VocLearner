package de.htw.VocLearner.web.api;

public class UebersetzungManipulationRequest {

    private String uebersetzung;
    private long wort_Fk;
    private String sprache;
    private float wahrscheinlichkeit;

    public UebersetzungManipulationRequest(String uebersetzung, long wort_Fk, String sprache, float wahrscheinlichkeit) {
        this.uebersetzung = uebersetzung;
        this.wort_Fk = wort_Fk;
        this.sprache = sprache;
        this.wahrscheinlichkeit = wahrscheinlichkeit;
    }

    public String getUebersetzung() {
        return uebersetzung;
    }

    public void setUebersetzung(String uebersetzung) {
        this.uebersetzung = uebersetzung;
    }

    public long getWort_Fk() {
        return wort_Fk;
    }

    public void setWort_Fk(long wort_Fk) {
        this.wort_Fk = wort_Fk;
    }

    public String getSprache() {
        return sprache;
    }

    public void setSprache(String sprache) {
        this.sprache = sprache;
    }

    public float getWahrscheinlichkeit() {
        return wahrscheinlichkeit;
    }

    public void setWahrscheinlichkeit(float wahrscheinlichkeit) {
        this.wahrscheinlichkeit = wahrscheinlichkeit;
    }

}
