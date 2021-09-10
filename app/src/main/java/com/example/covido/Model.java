package com.example.covido;

public class Model {

    private String name, total, actInc, decInc, recInc,death, cured, active;

    public Model(String name, String total, String death, String cured, String active, String actInc, String decInc, String recInc) {
        this.name = name;
        this.total = total;
        this.death = death;
        this.cured = cured;
        this.active = active;
        this.actInc = actInc;
        this.decInc = decInc;
        this.recInc = recInc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getDeath() {
        return death;
    }

    public void setDeath(String death) {
        this.death = death;
    }

    public String getCured() {
        return cured;
    }

    public void setCured(String cured) {
        this.cured = cured;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getActInc() {
        return actInc;
    }

    public void setActInc(String actInc) {
        this.actInc = actInc;
    }

    public String getDecInc() {
        return decInc;
    }

    public void setDecInc(String decInc) {
        this.decInc = decInc;
    }

    public String getRecInc() {
        return recInc;
    }

    public void setRecInc(String recInc) {
        this.recInc = recInc;
    }
}