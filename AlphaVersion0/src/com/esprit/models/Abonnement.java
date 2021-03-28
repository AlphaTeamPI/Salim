/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.models;

/**
 *
 * @author Iyed Zidi
 */
public class Abonnement {
    private int id ;
    private int duree ;
    private String typeService ;
    private int validite ;
    private float prix ;
    private int idService ;

    public Abonnement() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuree() {
        return duree;
    }

    public void setDuree(int duree) {
        this.duree = duree;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    public int getValidite() {
        return validite;
    }

    public void setValidite(int validite) {
        this.validite = validite;
    }

    public float getPrix() {
        return prix;
    }

    public void setPrix(float prix) {
        this.prix = prix;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public Abonnement(int id, int duree, String typeService, int validite, float prix, int idService) {
        this.id = id;
        this.duree = duree;
        this.typeService = typeService;
        this.validite = validite;
        this.prix = prix;
        this.idService = idService;
    }

    public Abonnement(int duree, String typeService, int validite, float prix, int idService) {
        this.duree = duree;
        this.typeService = typeService;
        this.validite = validite;
        this.prix = prix;
        this.idService = idService;
    }

    public Abonnement(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Abonnement{" + "id=" + id + ", duree=" + duree + ", typeService=" + typeService + ", validite=" + validite + ", prix=" + prix + ", idService=" + idService + "}\n";
    }
    
    
}
