/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;


import com.esprit.models.exercice;
import com.esprit.models.Abonnement;
import com.esprit.utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author trabe
 */

public class ServiceAbonnement implements IServiceAbonnement<Abonnement>{
    
    Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(Abonnement t) {
        try {
            String requete = "INSERT INTO Abonnement (duree,type_service,validite,prix,id_service) VALUES (?,?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getDuree());
            pst.setString(2, t.getTypeService());
            pst.setInt(3, t.getValidite());
            pst.setFloat(4, t.getPrix());
            pst.setInt(5, t.getIdService());
            pst.executeUpdate();
            System.out.println("Abonnement Ajoutée !");
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(Abonnement t) {
        try {
            String requete = "DELETE FROM Abonnement WHERE id_Abonnement=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,t.getId());
            pst.executeUpdate();
            System.out.println("Abonnement Supprimée !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(Abonnement t) {
        try {
            String requete = "UPDATE Abonnement SET duree=?, type_service=?, validite=?, prix=?, id_service=? WHERE id_Abonnement=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1, t.getDuree());
            pst.setString(2, t.getTypeService());
            pst.setInt(3, t.getValidite());
            pst.setFloat(4, t.getPrix());
            pst.setInt(5, t.getIdService());
            pst.setInt(6, t.getId());
            pst.executeUpdate();
            System.out.println("Abonnement Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<Abonnement> afficher() {
        List<Abonnement> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM Abonnement";
            Statement pst = cnx.prepareStatement(requete);          
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new Abonnement(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getInt(5))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    @Override
public List<Abonnement> triasc() {
        List<Abonnement> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM Abonnement order by id_Abonnement asc";
            PreparedStatement pst = cnx.prepareStatement(requete);
      
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
            list.add(new Abonnement(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getInt(5)));
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<Abonnement> tridesc() {
        List<Abonnement> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM Abonnement order by id_Abonnement desc";
            PreparedStatement pst = cnx.prepareStatement(requete);
      
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
              list.add(new Abonnement(rs.getInt(1), rs.getInt(2), rs.getString(3),rs.getInt(4),rs.getFloat(5),rs.getInt(5)));
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    public List afficherid() {
        List list = new ArrayList<>();
        
        try {
            String requete = "SELECT id_Abonnement FROM Abonnement";
            Statement pst = cnx.prepareStatement(requete);          
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new Abonnement(rs.getInt(1)).getId()); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }


}
