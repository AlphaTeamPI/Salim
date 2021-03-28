/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.models;

import java.util.Date;

/**
 *
 * @author asus
 */
public class Commande {
    private int IdCommande;
    private int IdClient;
    private Date DateCom;
    private float MontantCom;
    private String EtatCom;
    
    public Commande() {
    }

    public Commande(int IdCommande) {
        this.IdCommande = IdCommande;
    }
    
    public Commande(int IdClient, Date DateCom, float MontantCom, String EtatCom) {
        this.IdClient = IdClient;
        this.DateCom = DateCom;
        this.MontantCom = MontantCom;
        this.EtatCom = EtatCom;
    }

    public Commande(Date DateCom, float MontantCom, String EtatCom) {
        this.DateCom = DateCom;
        this.MontantCom = MontantCom;
        this.EtatCom = EtatCom;
    }
    
    
    public Commande(int IdCommande, int IdClient, Date DateCom, float MontantCom, String EtatCom) {
        this.IdCommande = IdCommande;
        this.IdClient = IdClient;
        this.DateCom = DateCom;
        this.MontantCom = MontantCom;
        this.EtatCom = EtatCom;
    }

    public int getIdCommande() {
        return IdCommande;
    }
    
    public void setIdCommande(int IdCommande) {
        this.IdCommande = IdCommande;
    }

    public int getIdClient() {
        return IdClient;
    }

    public void setIdClient(int IdClient) {
        this.IdClient = IdClient;
    }

    public Date getDateCom() {
        return DateCom;
    }

    public void setDateCom(Date DateCom) {
        this.DateCom = DateCom;
    }

    public float getMontantCom() {
        return MontantCom;
    }

    public void setMontantCom(float MontantCom) {
        this.MontantCom = MontantCom;
    }

    public String getEtatCom() {
        return EtatCom;
    }

    public void setEtatCom(String EtatCom) {
        this.EtatCom = EtatCom;
    }
    @Override
    public String toString(){
        return "Commandes[" + "ID: " +IdCommande +" ID Client: " + IdClient + " Date commande: "
                + DateCom + " Montant commande: " + MontantCom +" Etat commande: " + EtatCom;}
}