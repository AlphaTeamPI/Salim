/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.models;

/**
 *
 * @author asus
 */
public class LigneCommande {
    private int Id;
    private int IdCommande;
    private int IdProduit;
    private int QuantiteProduit;
    private float PrixUnitaire;
    private float PrixTotal;

    public LigneCommande() {
    }

    public LigneCommande(int QuantiteProduit, float PrixUnitaire, float PrixTotal) {
        this.QuantiteProduit = QuantiteProduit;
        this.PrixUnitaire = PrixUnitaire;
        this.PrixTotal = PrixTotal;
    }

    public LigneCommande(int Id, int IdCommande, int IdProduit, int QuantiteProduit, float PrixUnitaire, float PrixTotal) {
        this.Id = Id;
        this.IdCommande = IdCommande;
        this.IdProduit = IdProduit;
        this.QuantiteProduit = QuantiteProduit;
        this.PrixUnitaire = PrixUnitaire;
        this.PrixTotal = PrixTotal;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdCommande() {
        return IdCommande;
    }

    public void setIdCommande(int IdCommande) {
        this.IdCommande = IdCommande;
    }

    public int getIdProduit() {
        return IdProduit;
    }

    public void setIdProduit(int IdProduit) {
        this.IdProduit = IdProduit;
    }

    public int getQuantiteProduit() {
        return QuantiteProduit;
    }

    public void setQuantiteProduit(int QuantiteProduit) {
        this.QuantiteProduit = QuantiteProduit;
    }

    public float getPrixUnitaire() {
        return PrixUnitaire;
    }

    public void setPrixUnitaire(float PrixUnitaire) {
        this.PrixUnitaire = PrixUnitaire;
    }

    public float getPrixTotal() {
        return PrixTotal;
    }

    public void setPrixTotal(float PrixTotal) {
        this.PrixTotal = PrixTotal;
    }
    
    @Override
    public String toString(){
        return "Commandes[" + "ID: " +IdCommande +" ID Client: " + IdProduit +
                " Prix unitaire: " + PrixUnitaire +" Prix total: " + PrixTotal;}
}
