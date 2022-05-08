package de.htw.VocLearner.persistence;

import javax.persistence.*;

@Entity(name = "Uebersetzung")
public class UebersetzungEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "uebersetzung", nullable = false)
    private String uebersetzung;

    @Column(name = "wort_Fk", nullable = false)
    private long wort_Fk;

    @Column(name = "sprache", nullable = false)
    private String sprache;

    @Column(name = "wahrscheinlichkeit", nullable = false)
    private float wahrscheinlichkeit;

    public UebersetzungEntity(long id, String uebersetzung, long wort_Fk, String sprache, float wahrscheinlichkeit) {
        this.id = id;
        this.uebersetzung = uebersetzung;
        this.wort_Fk = wort_Fk;
        this.sprache = sprache;
        this.wahrscheinlichkeit = wahrscheinlichkeit;
    }

    protected UebersetzungEntity(){
    }

    public long getId() {
        return id;
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