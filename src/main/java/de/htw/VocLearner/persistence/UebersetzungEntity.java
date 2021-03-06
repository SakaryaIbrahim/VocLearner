package de.htw.VocLearner.persistence;

import de.htw.VocLearner.web.api.Uebersetzung;
import de.htw.VocLearner.web.api.WordTranslation;

import javax.persistence.*;

@Entity(name = "Uebersetzung")
public class UebersetzungEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "uebersetzung", nullable = false)
    private String uebersetzung;

    @Column(name = "sprache", nullable = false)
    private String sprache;

    @Column(name = "wahrscheinlichkeit", nullable = false)
    private float wahrscheinlichkeit;


    public UebersetzungEntity(String uebersetzung, String sprache, float wahrscheinlichkeit) {
        this.uebersetzung = uebersetzung;
        this.sprache = sprache;
        this.wahrscheinlichkeit = wahrscheinlichkeit;
    }
    public UebersetzungEntity(long id,String uebersetzung,String sprache,float wahrscheinlichkeit){
        this.id = id;
        this.uebersetzung = uebersetzung;
        this.sprache = sprache;
        this.wahrscheinlichkeit = wahrscheinlichkeit;
    }

    protected UebersetzungEntity(){
    }

    public long getId() {
        return id;
    }

    public void setId(long id) { this.id = id;}
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

    @Override
    public String toString() {
        return "UebersetzungEntity{" +
                "id=" + id +
                ", uebersetzung='" + uebersetzung + '\'' +
                ", sprache='" + sprache + '\'' +
                ", wahrscheinlichkeit=" + wahrscheinlichkeit +
                '}';
    }
}
