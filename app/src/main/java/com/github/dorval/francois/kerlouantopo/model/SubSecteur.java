package com.github.dorval.francois.kerlouantopo.model;

import com.github.dorval.francois.kerlouantopo.model.Secteur;

public class SubSecteur {


    private String nom;



    private Secteur.ID id;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Secteur.ID getId() {
        return id;
    }

    public void setId(Secteur.ID id) {
        this.id = id;
    }
}
