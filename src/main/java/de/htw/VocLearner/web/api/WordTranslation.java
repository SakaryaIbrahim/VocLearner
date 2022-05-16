package de.htw.VocLearner.web.api;

public class WordTranslation {
    private String word ;
    private String language ;
    private String tanslation ;
    private String tranLanguage;

    public WordTranslation(String word, String language, String tanslation, String tranLanguage) {
        this.word = word;
        this.language = language;
        this.tanslation = tanslation;
        this.tranLanguage = tranLanguage;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getTanslation() {
        return tanslation;
    }

    public void setTanslation(String tanslation) {
        this.tanslation = tanslation;
    }

    public String getTranLanguage() {
        return tranLanguage;
    }

    public void setTranLanguage(String tranLanguage) {
        this.tranLanguage = tranLanguage;
    }
}
