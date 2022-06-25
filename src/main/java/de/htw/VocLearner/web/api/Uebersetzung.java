package de.htw.VocLearner.web.api;

public class Uebersetzung {

    private long id;
    private String uebersetzung;
    private String sprache;
    private float wahrscheinlichkeit;

    public Uebersetzung(long id, String uebersetzung, String sprache, float wahrscheinlichkeit) {
        this.id = id;
        this.uebersetzung = uebersetzung;
        this.sprache = sprache;
        this.wahrscheinlichkeit = wahrscheinlichkeit;
    }

    public Uebersetzung(){

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUebersetzung() {
        return uebersetzung;
    }

    public void setUebersetzung(String uebersetzung) {
        this.uebersetzung = uebersetzung;
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
