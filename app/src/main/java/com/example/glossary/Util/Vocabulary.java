package com.example.glossary.Util;

import java.io.Serializable;

public class Vocabulary implements Serializable {

    private String id;
    private String english;
    private String spanish;
    private String definition;
    private String hyperlink;

    public Vocabulary() {
    }

    public Vocabulary(String id, String english, String spanish, String definition, String hyperlink) {
        this.id = id;
        this.english = english;
        this.spanish = spanish;
        this.definition = definition;
        this.hyperlink = hyperlink;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEnglish() {
        return english;
    }

    public void setEnglish(String english) {
        this.english = english;
    }

    public String getSpanish() {
        return spanish;
    }

    public void setSpanish(String spanish) {
        this.spanish = spanish;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getHyperlink() {
        return hyperlink;
    }

    public void setHyperlink(String hyperlink) {
        this.hyperlink = hyperlink;
    }
}
