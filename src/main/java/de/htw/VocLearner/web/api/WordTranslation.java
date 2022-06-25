package de.htw.VocLearner.web.api;


public class WordTranslation {
    private String word ;
    private String language ;
    private String translation ;
    private String transLanguage;

    public WordTranslation(String word, String language, String translation, String transLanguage) {
        this.word = word;
        this.language = language;
        this.translation = translation;
        this.transLanguage = transLanguage;
    }

    public WordTranslation(){

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

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTransLanguage() {
        return transLanguage;
    }

    public void setTransLanguage(String transLanguage) {
        this.transLanguage = transLanguage;
    }
}
