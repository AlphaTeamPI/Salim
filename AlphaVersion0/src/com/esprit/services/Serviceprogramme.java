/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;


import com.esprit.models.exercice;
import com.esprit.models.programme;
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

public class Serviceprogramme implements IService<programme>{
    
    Connection cnx = DataSource.getInstance().getCnx();
    
    @Override
    public void ajouter(programme t) {
        try {
            String requete = "INSERT INTO programme (difficulte,type,duree,progression) VALUES (?,?,?,?)";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getDifficulte());
            pst.setString(2, t.getType());
            pst.setInt(3, t.getDuree());
            pst.setInt(4, t.getProgression());
            pst.executeUpdate();
            System.out.println("programme Ajoutée !");
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void supprimer(programme t) {
        try {
            String requete = "DELETE FROM programme WHERE id_programme=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setInt(1,t.getId());
            pst.executeUpdate();
            System.out.println("programme Supprimée !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public void modifier(programme t) {
        try {
            String requete = "UPDATE programme SET difficulte=?, type=?, duree=?, progression=? WHERE id_programme=?";
            PreparedStatement pst = cnx.prepareStatement(requete);
            pst.setString(1, t.getDifficulte());
            pst.setString(2, t.getType());
            pst.setInt(3, t.getDuree());
            pst.setInt(4, t.getProgression());
            pst.setInt(5, t.getId());
            pst.executeUpdate();
            System.out.println("programme Modfié !");
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
    }

    @Override
    public List<programme> afficher() {
        List<programme> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM programme";
            Statement pst = cnx.prepareStatement(requete);          
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new programme(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5))); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    @Override
public List<programme> triasc() {
        List<programme> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM programme order by id_programme asc";
            PreparedStatement pst = cnx.prepareStatement(requete);
      
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
            list.add(new programme(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5)));
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }

    @Override
    public List<programme> tridesc() {
        List<programme> list = new ArrayList<>();
        
        try {
            String requete = "SELECT * FROM programme order by id_programme desc";
            PreparedStatement pst = cnx.prepareStatement(requete);
      
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
              list.add(new programme(rs.getInt(1), rs.getString(2), rs.getString(3),rs.getInt(4),rs.getInt(5)));
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }
    public List afficherid() {
        List list = new ArrayList<>();
        
        try {
            String requete = "SELECT id_programme FROM programme";
            Statement pst = cnx.prepareStatement(requete);          
            ResultSet rs = pst.executeQuery(requete);
            while (rs.next()) {
                list.add(new programme(rs.getInt(1)).getId()); 
            }
            
        } catch(SQLException ex) {
            System.err.println(ex.getMessage());
        }
        return list;
    }


}
