/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;


import com.esprit.models.exercice;
import com.esprit.models.exercice;
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

public class Serviceexercice implements IServiceex<exercice>{
    
    Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(exercice t) {
        try {
            String requete = "INSERT INTO exercices (nom,description) VALUES (?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(2, t.getDescription());
            pst.setString(1, t.getNom());

            pst.executeUpdate();
            System.out.println("exercice Ajoutée !");
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(exercice t) {
        try {
            String requete = "DELETE FROM exercices WHERE id_exercice=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,t.getId_exercice());
            pst.executeUpdate();
            System.out.println("exercice Supprimée !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(exercice t) {
        try {
            String requete = "UPDATE exercices SET nom=?, description=?  WHERE id_exercice=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(2, t.getDescription());
            pst.setString(1, t.getNom());
            pst.setInt(3, t.getId_exercice());
            pst.executeUpdate();
            System.out.println("exercice Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<exercice> afficher() {
        List<exercice> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM exercices";
            Statement pst = cnx.prepareStatement(requete);          
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new exercice(rs.getInt(1), rs.getString(2),rs.getString(3))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    @Override
public List<exercice> triasc() {
        List<exercice> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM exercices order by id_exercice asc";
            PreparedStatement pst = cnx.prepareStatement(requete);
      
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
            list.add(new exercice(rs.getInt(1), rs.getString(2),rs.getString(3)));
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<exercice> tridesc() {
        List<exercice> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM exercices order by id_exercice desc";
            PreparedStatement pst = cnx.prepareStatement(requete);
      
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
              list.add(new exercice(rs.getInt(1), rs.getString(2),rs.getString(3)));
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    public List afficherid() {
        List list = new ArrayList<>();
        
        try {
            String requete = "SELECT id_exercice FROM exercices";
            Statement pst = cnx.prepareStatement(requete);          
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new exercice(rs.getInt(1)).getId_exercice()); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }


}
