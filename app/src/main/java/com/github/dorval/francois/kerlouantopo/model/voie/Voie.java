package com.github.dorval.francois.kerlouantopo.model.voie;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Scanner;

public class Voie implements Comparable<Voie>, Serializable{


    public static final String VOIE = "VOIE";

    Long id;

    Cotation cotation;

    private String nom;

    private String commentaire;


    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }


    public String getNom() {return nom;}

    public void setNom(String nom) {this.nom = nom;}

    public String getCommentaire() {return commentaire;  }

    public void setCommentaire(String commentaire) {        this.commentaire = commentaire;    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    @Override
    public int compareTo(@NonNull Voie voie) {
        return (int)(id-voie.id);
    }

    @Override
    public String toString() {
        return "Voie{" +
                "id=" + id +
                ", cotation=" + cotation +
                ", nom='" + nom + '\'' +
                ", commentaire='" + commentaire + '\'' +
                '}';
    }
}
