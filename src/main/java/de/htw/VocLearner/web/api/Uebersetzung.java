package de.htw.VocLearner.web.api;

public class Uebersetzung {

    private long id;
    private String uebersetzung;
    private long wort_Fk;
    private String sprache;
    private float wahrscheinlichkeit;

    public Uebersetzung(long id, String uebersetzung, long wort_Fk, String sprache, float wahrscheinlichkeit) {
        this.id = id;
        this.uebersetzung = uebersetzung;
        this.wort_Fk = wort_Fk;
        this.sprache = sprache;
        this.wahrscheinlichkeit = wahrscheinlichkeit;
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
