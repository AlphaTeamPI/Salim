/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

/**
 *
 * @author Administrator
 */
public class exercice {
    private int id_exercice;
    private String nom;
    private String description;

    public exercice() {
    }

    public exercice(int id_exercice, String nom, String description) {
        this.id_exercice = id_exercice;
        this.nom = nom;
        this.description = description;
    }

    public exercice(int id_exercice) {
        this.id_exercice = id_exercice;
    }

    public exercice(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }

    public int getId_exercice() {
        return id_exercice;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }

    public void setId_exercice(int id_exercice) {
        this.id_exercice = id_exercice;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }


   
    
}
