/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import tn.esprit.utilis.DataSource;
import tn.esprit.models.LigneCommande;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ServiceLigneCommande implements IServiceLigneCommande<LigneCommande>{

    Connection cnx = DataSource.getInstance().getCnx();
   
//******************************** 
    @Override
    public void ajouter(LigneCommande lc) {
        try {
            String requete = "INSERT INTO ligne_commande (Id,IdCommande,IdProduit,QuantiteProduit,PrixUnitaire,PrixTotal) VALUES (?,?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, lc.getId());
            pst.setInt(2, lc.getIdCommande());
            pst.setInt(3, lc.getIdProduit());
            pst.setInt(4, lc.getQuantiteProduit());
            pst.setFloat(5, lc.getPrixUnitaire());
            pst.setFloat(6, lc.getPrixTotal());
            pst.executeUpdate();
            System.out.println("Ligne commande ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(int id) {
        try{
            String requete = "DELETE FROM ligne_commande WHERE Id=" + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Ligne commande suprimée !");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public void modifier(LigneCommande lc,int id){
        try{
                String requete = "update  "
                        + "ligne_commande set EtatCom =?,MontantCom=?"
                        + " where Id =?";
                PreparedStatement pst = cnx.prepareStatement(requete);
                pst.setFloat(1, lc.getPrixUnitaire());
                pst.setFloat(2, lc.getPrixTotal());
                pst.setInt(3, id);
                pst.executeUpdate();
                System.out.println("Commande modifiée !");
                } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public List<LigneCommande> afficher() {
        List<LigneCommande> list = new ArrayList<>();
        try {
            System.out.println("************************Liste des commandes************************");
            String requete = "SELECT * FROM ligne_commande";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new LigneCommande(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6)));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println(toString());
        return list;
    }
    
    @Override
    public int nombre() {
        int i = 0;
        String requete = "SELECT COUNT(*) as nbr FROM ligne_commande";

        try {
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);

            while (rs.next()) {

                i = rs.getInt("nbr");

            }
        } catch (SQLException ex) {
             System.err.println(ex.getMessage());
        }
        return i;
    }
    @Override
    public List<LigneCommande> rechercheID(int r) {
        List<LigneCommande> list = new ArrayList<>();
        try {
            String requete = "SELECT * from commande where IdCommande like'"+r+"'";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new LigneCommande(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6)));
            }
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return list;
    }

    @Override
    public List<LigneCommande> tridesc() {
        List<LigneCommande> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM commande order by IdCommande desc";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new LigneCommande(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getFloat(5), rs.getFloat(6)));
            }
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    }
