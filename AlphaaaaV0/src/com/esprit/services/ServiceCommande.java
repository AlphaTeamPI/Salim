/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.esprit.utils.DataSource;
import com.esprit.models.Commande;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asus
 */
public class ServiceCommande implements IServiceCommande<Commande>{

    Connection cnx = DataSource.getInstance().getCnx();
   
//******************************** 
    @Override
    public void ajouter(Commande c) {
        try {
            String requete = "INSERT INTO commande (IdCommande,IdClient,DateCom,MontantCom,EtatCom) VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, c.getIdCommande());
            pst.setInt(2, c.getIdClient());
            pst.setDate(3, new java.sql.Date(c.getDateCom().getTime()));
            pst.setFloat(4, c.getMontantCom());
            pst.setString(5, c.getEtatCom());
            pst.executeUpdate();
            System.out.println("Commande ajoutée !");

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    @Override
    public void supprimer(Commande c) {
        try{
            String requete = "DELETE FROM commande WHERE IdCommande=" + c.getIdCommande();
            Statement st = cnx.createStatement();
            st.executeUpdate(requete);
            System.out.println("Commande suprimée !");
        }
        catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    //////////////////////////
    @Override
    public void modifier(Commande c,int id){
        try{
                String requete = "update  "
                        + "commande set DateCom=?,EtatCom =?,MontantCom=?"
                        + " where IdCommande =?";
                PreparedStatement pst = cnx.prepareStatement(requete);
                pst.setDate(1, new java.sql.Date(c.getDateCom().getTime()));
                pst.setString(2, c.getEtatCom());
                pst.setFloat(3, c.getMontantCom());
                pst.setInt(4, id);
                pst.executeUpdate();
                System.out.println("Commande modifiée !");
                } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }
    @Override
    public List<Commande> afficher() {
        List<Commande> list = new ArrayList<>();
        try {
            String requete = "SELECT * FROM commande";
            Statement st = cnx.createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                list.add(new Commande(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getFloat(4),rs.getString("EtatCom")));
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
        
        return list;
    }
    
    @Override
    public int nombre() {
        int i = 0;
        String requete = "SELECT COUNT(*) as nbr FROM Commande";

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

//    @Override
//    public List<Commande> rechercheID(int r) {
//        List<Commande> list = new ArrayList<>();
//        try {
//            String requete = "SELECT * from commande where IdCommande like'"+r+"'";
//            Statement st = cnx.createStatement();
//            ResultSet rs = st.executeQuery(requete);
//            while (rs.next()) {
//                list.add(new Commande(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getFloat(4),rs.getString("EtatCom")));
//            }
//        } catch (SQLException ex) {
//            System.err.println(ex.getMessage());
//        }
//
//        return list;
//    }

    @Override
    public List<Commande> tridesc() {
        List<Commande> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM commande order by IdCommande desc";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
              list.add(new Commande(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getFloat(4),rs.getString("EtatCom")));
            }
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
     @Override
    public List<Commande> triasc() {
        List<Commande> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM commande order by IdCommande asc";
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
              list.add(new Commande(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getFloat(4),rs.getString("EtatCom")));
            }
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    
    public List afficherid() {
        List list = new ArrayList<>();
        
        try {
            String requete = "SELECT idCommande FROM commande";
            Statement pst = cnx.prepareStatement(requete);          
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new Commande(rs.getInt(1)).getIdCommande()); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    }
