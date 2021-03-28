/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;

import com.esprit.models.Commande;
import com.esprit.services.ServiceCommande;
import com.esprit.utils.DataSource;
import java.net.URL;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CommandesController implements Initializable {

    private TextField IdClient;
    @FXML
    private Button btn;
    @FXML
    private TableView<Commande> table;
    @FXML
    private TableColumn<Commande,Integer> IdCommandea;
    @FXML
    private TableColumn<Commande, Integer> IdClienta;
    @FXML
    private TableColumn<Commande, DatePicker> datea;
    @FXML
    private TableColumn<Commande, String> etata;
    @FXML
    private TableColumn<Commande, Float> montanta;
    @FXML
    private TextField id_mod;
    @FXML
    private DatePicker datem;
    @FXML
    private TextField etatm;
    @FXML
    private Button ok;
    @FXML
    private TextField etatC;
    @FXML
    private TextField montantC;
    @FXML
    private TextField montantm;
    @FXML
    private ComboBox<Integer> id_sup;
    @FXML
    private TextField rechercher;
    @FXML
    private DatePicker dateC;
    @FXML
    private TextField IdCLient;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        view();
        viewid();
        view();
    }
    
    public void view(){
         try {
            ServiceCommande sc = new ServiceCommande();
           ArrayList<Commande> lv;
       
            lv = (ArrayList<Commande>) sc.afficher();
            ObservableList<Commande> data = FXCollections.observableArrayList(lv);
            IdCommandea.setCellValueFactory(new PropertyValueFactory<>("IdCommande"));
            IdClienta.setCellValueFactory(new PropertyValueFactory<>("IdClient"));
            datea.setCellValueFactory(new PropertyValueFactory<>("DateCom"));
            etata.setCellValueFactory(new PropertyValueFactory<>("EtatCom"));
            montanta.setCellValueFactory(new PropertyValueFactory<>("MontantCom"));
            table.setItems(data);
          
        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    @FXML
    private void refresh(ActionEvent event) {
        view();
    }
    
    @FXML
    private void Ajouter(MouseEvent event) {
        if (verifUserChampsajouter()) {
            ServiceCommande sc = new ServiceCommande();
            String s0=IdCLient.getText();
            int si0=Integer.parseInt(s0);
            LocalDate d1= dateC.getValue();
            Date datex = Date.valueOf(d1);
            String s1=etatC.getText();
            String s2=montantC.getText();
            Float si2=Float.parseFloat(s2);
            sc.ajouter(new Commande(si0,datex,si2,s1)); 
            JOptionPane.showMessageDialog(null, "Commande ajoutée !");
            view();
            viewid();
        }
    }
    
    @FXML
    private void modify(MouseEvent event) {
        Commande c = table.getSelectionModel().getSelectedItem();
        String id  = Integer.toString(c.getIdCommande());
        id_mod.setText(id);
        etatm.setText(c.getEtatCom());
        String montant = Float.toString(c.getMontantCom());
        montantm.setText(montant);
    }

    @FXML
    private void modifier(ActionEvent event) {
        if (verifUserChampsmodifier()){
            int y = ( datem.getValue().getYear() % 100 )+ 100 ;
            int m = datem.getValue().getMonthValue()-1;
            int day= datem.getValue().getDayOfMonth();
            java.util.Date d = new java.util.Date(y,m,day);
            ServiceCommande sc = new ServiceCommande();
            Commande s =  new Commande(d,Integer.parseInt(montantm.getText()),etatm.getText());
            String s0=id_mod.getText();
            int si0=Integer.parseInt(s0);
            sc.modifier(s,si0);
            JOptionPane.showMessageDialog(null, "Commande modifiier !");
            etatm.setText("");
            montantm.setText("");
            datem.setValue(null);
            view(); 
        }
    }
    
    public void viewid() {
        ServiceCommande sc = new ServiceCommande();

        ArrayList lv;

        lv = (ArrayList) sc.afficherid();
        ObservableList data = FXCollections.observableArrayList(lv);
        id_sup.setItems(data);
    }
    
    @FXML
    private void supprimer(ActionEvent event) {
        ServiceCommande sc = new ServiceCommande();
        Commande c = new Commande();
        c.setIdCommande((int) id_sup.getSelectionModel().getSelectedItem());
        sc.supprimer(c);
        JOptionPane.showMessageDialog(null, "Commande Supprimée !");
        view();
        viewid();
    }

    @FXML
    private void rechercher(ActionEvent event) {
        ObservableList<Commande> list = FXCollections.observableArrayList();
        try {
             Connection cnx = DataSource.getInstance().getCnx();
            String requete = "SELECT * FROM commande where IdCommande = "+rechercher.getText()+"";
            System.out.println(rechercher.getText());
            PreparedStatement pst = cnx.prepareStatement(requete);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
             list.add(new Commande(rs.getInt(1), rs.getInt(2), rs.getDate(3), rs.getFloat(4),rs.getString(5)));
//             id_mod.setText(String.valueOf(rs.getInt(1)));
//             desc.setText(rs.getString(2));
//             type.setText(rs.getString(3));
//             date.setValue(rs.getDate(4).toLocalDate());
            }

        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }
            IdCommandea.setCellValueFactory(new PropertyValueFactory<>("IdCommande"));
            IdClienta.setCellValueFactory(new PropertyValueFactory<>("IdClient"));
            datea.setCellValueFactory(new PropertyValueFactory<>("DateCom"));
            etata.setCellValueFactory(new PropertyValueFactory<>("EtatCom"));
            montanta.setCellValueFactory(new PropertyValueFactory<>("MontantCom"));
            table.setItems(list);
    }
    
    @FXML
    private void menu(ActionEvent event) {
    }
    
/***************Controlede saisie***********/
    
    public boolean verifUserChampsajouter() {
        int verif = 0;
        String style = " -fx-border-color: red;";

        String styledefault = "-fx-border-color: green;";

        IdCLient.setStyle(styledefault);
        dateC.setStyle(styledefault);
        etatC.setStyle(styledefault);
        montantC.setStyle(styledefault);

        if (IdCLient.getText().equals("")) {
            IdCLient.setStyle(style);
            verif = 1;
        }
//        if (dateC.getValue().equals("")) {
//            dateC.setStyle(style);
//            verif = 1;
//        }
        if (etatC.getText().equals("")) {
            etatC.setStyle(style);
            verif = 1;
        }
        if (montantC.getText().equals("")) {
            montantC.setStyle(style);
            verif = 1;
        }
        if (verif == 0) {
            return true;
        }
        
        JOptionPane.showMessageDialog(null, "Remplir tous les champs!");
        return false;
    }

    public boolean verifUserChampsmodifier() {
        int verif = 0;
        String style = " -fx-border-color: red;";

        String styledefault = "-fx-border-color: green;";

        datem.setStyle(styledefault);
        etatm.setStyle(styledefault);
        montantm.setStyle(styledefault);
        id_mod.setStyle(styledefault);
//        if (datem.getText().equals("")) {
//            datem.setStyle(style);
//            verif = 1;
//        }
        if (etatm.getText().equals("")) {
            etatm.setStyle(style);
            verif = 1;
        }
        if (montantm.getText().equals("")) {
            montantm.setStyle(style);
            verif = 1;
        }
        if (id_mod.getText().equals("")) {
            id_mod.setStyle(style);
            verif = 1;
        }
        if (verif == 0) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Verfier tous les champs");
        return false;
    }
}