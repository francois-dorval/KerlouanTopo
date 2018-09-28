package com.github.dorval.francois.kerlouantopo.model;

import java.util.ArrayList;
import java.util.List;

public class Secteur {

    public  enum ID{
        NEIZVRAN,
        NEIZVRAN1,
        NEIZVRAN1_1,
        NEIZVRAN1_2
    }


    private String nom;

    private String map;

    private ID id;

    private String description1;

    private String description2;

    private List<SubSecteur> subsecteurs= new ArrayList<>();

    private List<Voie> voies = new ArrayList<>();

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getDescription1() {
        return description1;
    }

    public void setDescription1(String description1) {
        this.description1 = description1;
    }

    public String getDescription2() {
        return description2;
    }

    public void setDescription2(String description2) {
        this.description2 = description2;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public List<Voie> getVoies() {
        return voies;
    }

    public void setVoies(List<Voie> voies) {
        this.voies = voies;
    }

    public List<SubSecteur> getSubsecteurs() {return subsecteurs;}

    public void setSubsecteurs(List<SubSecteur> subsecteurs) {this.subsecteurs = subsecteurs;}
}
