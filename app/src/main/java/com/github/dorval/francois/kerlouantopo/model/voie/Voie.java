package com.github.dorval.francois.kerlouantopo.model.voie;

import android.support.annotation.NonNull;

import java.io.Serializable;
import java.util.Scanner;

public class Voie implements Comparable<Voie>, Serializable{


    public static final String VOIE = "VOIE";

    String ligne;


    Cotation cotation;

    private String ouvreur;

    private String nom;

    private String commentaire;

    private Long id;
    private Long idSecteur;


    public String getSecteur() {
        return ligne;
    }

    public void setLigne(String ligne) {
        this.ligne = ligne;
    }


    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }

    public String getOuvreur() {return ouvreur;}

    public void setOuvreur(String ouvreur) {this.ouvreur = ouvreur;}

    public String getNom() {return nom;}

    public void setNom(String nom) {this.nom = nom;}

    public String getCommentaire() {return commentaire;  }

    public void setCommentaire(String commentaire) {        this.commentaire = commentaire;    }

    @Override
    public String toString() {
        return "Voie{" +
                ", cotation=" + cotation +
                '}';
    }

    @Override
    public int compareTo(@NonNull Voie voie) {
        if (ligne == null) {
            return 1;
        }
        try {
            Scanner left = new Scanner(ligne).useDelimiter("[^0-9]+");
            int ileft = left.nextInt();

            Scanner right = new Scanner(voie.ligne).useDelimiter("[^0-9]+");
            int iright = right.nextInt();
            return ileft - iright;
        } catch (Exception e) {
            return ligne.compareTo(voie.getLigne());
        }

    }

    public static boolean memeLigne(Voie voie1, Voie voie2){
        if (voie1 == null && voie2 == null){
            return true;
        }
        if (voie1 == null && voie2 != null){
            return false;
        }
        if (voie1 != null && voie2 == null){
            return false;
        }

        if (voie1.ligne == null && voie2.ligne == null ){
            return true;
        }

        return voie1.ligne.equals(voie2.ligne);
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLigne() {
        return ligne;
    }

    public void setIdSecteur(Long idSecteur) {
        this.idSecteur = idSecteur;
    }

    public Long getIdSecteur() {
        return idSecteur;
    }
}
