/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;


import com.esprit.models.exercice;
import com.esprit.services.Serviceexercice;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author trabe
 */
public class AjoutExerciceController implements Initializable {

    @FXML
    private Button btn;
    @FXML  
    private TableView<exercice> table;
    @FXML
    private TextField id_mod;
    @FXML
    private Button ok;
    @FXML
    private CheckBox ch1;
    @FXML
    private CheckBox ch;
    @FXML
    private TableColumn<exercice,Integer> id_exercice;
    @FXML
    private ComboBox<Integer> id_sup;
    @FXML
    private TextField rechercher;
    @FXML
    private TextField nom;
    @FXML
    private TextField description;
    @FXML
    private TableColumn<exercice, String> noma;
    @FXML
    private TableColumn<exercice, String> descriptiona;
    @FXML
    private TextField nom1;
    @FXML
    private TextField description1;
    
     
     public void view(){
         try {
            Serviceexercice sc = new Serviceexercice();
        

           ArrayList<exercice> lv;
       
            lv = (ArrayList<exercice>) sc.afficher();
            ObservableList<exercice> data = FXCollections.observableArrayList(lv);
            id_exercice.setCellValueFactory(new PropertyValueFactory<exercice,Integer>("id_exercice"));
            noma.setCellValueFactory(new PropertyValueFactory<exercice,String>("nom"));
            descriptiona.setCellValueFactory(new PropertyValueFactory<exercice,String>("description"));

            table.setItems(data);
          
        } catch (Exception ex) {
            Logger.getLogger(AjoutExerciceController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       view();
       viewid();
           
    }    
    @FXML
    private void supprimer(ActionEvent event) {
Serviceexercice sp = new Serviceexercice();
        exercice l = new exercice();

//    String id = gid.getText();
//        l.setId_membre(Integer.parseInt(id));
        l.setId_exercice(id_sup.getSelectionModel().getSelectedItem());
        
        sp.supprimer(l);
        view();
        viewid();
    }

    @FXML
    private void modifier(ActionEvent event) {
        if(verifUserChampsmodifier()){
        Serviceexercice sp = new Serviceexercice();
          String s=id_mod.getText();
          int si=Integer.parseInt(s);
        sp.modifier(new exercice(si,nom1.getText(),description1.getText()));
        
        JOptionPane.showMessageDialog(null, "Exercice modifiée !");
        view();}
    }


    @FXML
    private void rechercher(ActionEvent event) {
        if(ch.isSelected()){
           
        try {
            Serviceexercice sc = new Serviceexercice();
        

           ArrayList<exercice> lv;


            lv = (ArrayList<exercice>) sc.tridesc();
            ObservableList<exercice> data = FXCollections.observableArrayList(lv);
            id_exercice.setCellValueFactory(new PropertyValueFactory<exercice,Integer>("id_exercice"));
            noma.setCellValueFactory(new PropertyValueFactory<exercice,String>("nom"));
            descriptiona.setCellValueFactory(new PropertyValueFactory<exercice,String>("description"));
            table.setItems(data);
          
        } catch (Exception ex) {
            Logger.getLogger(AjoutExerciceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
  if(ch1.isSelected()){
    ch.setSelected(false);
        try {
            Serviceexercice sc = new Serviceexercice();
        

           ArrayList<exercice> lv;
            lv = (ArrayList<exercice>) sc.triasc();
            ObservableList<exercice> data = FXCollections.observableArrayList(lv);
          id_exercice.setCellValueFactory(new PropertyValueFactory<exercice,Integer>("id_exercice"));
            noma.setCellValueFactory(new PropertyValueFactory<exercice,String>("nom"));
            descriptiona.setCellValueFactory(new PropertyValueFactory<exercice,String>("description"));
            table.setItems(data);
          
        } catch (Exception ex) {
            Logger.getLogger(AjoutExerciceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }


    @FXML
    private void ch2(ActionEvent event) {
        ch.setSelected(false);
    }

    @FXML
    private void ch1(ActionEvent event) {
        ch1.setSelected(false);
    }
    @FXML
    private void modify(MouseEvent event) {
        exercice r = table.getSelectionModel().getSelectedItem();
        String id  = Integer.toString(r.getId_exercice());
        id_mod.setText(id);
        nom1.setText(r.getNom());
        description1.setText(r.getDescription());
    }
     public void viewid(){
   Serviceexercice sc = new Serviceexercice();
        

           ArrayList lv;
       
            lv = (ArrayList) sc.afficherid();
            ObservableList data = FXCollections.observableArrayList(lv);
        id_sup.setItems(data);
     }
     public boolean verifUserChampsajouter() {
        int verif = 0;
        String style = " -fx-border-color: red;";

        String styledefault = "-fx-border-color: green;";

   
       
        nom.setStyle(styledefault);
        description.setStyle(styledefault);



 

        if (nom.getText().equals("")) {
            nom.setStyle(style);
            verif = 1;
        }
       
        if (description.getText().equals("")) {
            description.setStyle(style);
            verif = 1;
        }
        if (verif == 0) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Verfie!");
        return false;
    }

   public boolean verifUserChampsmodifier() {
        int verif = 0;
        String style = " -fx-border-color: red;";

        String styledefault = "-fx-border-color: green;";

   
       
        nom1.setStyle(styledefault);
        description1.setStyle(styledefault);
        id_mod.setStyle(styledefault);
        if (nom1.getText().equals("")) {
            nom1.setStyle(style);
            verif = 1;
        }
       
        if (description1.getText().equals("")) {
            description1.setStyle(style);
            verif = 1;
        }
           if (id_mod.getText().equals("")) {
            id_mod.setStyle(style);
            verif = 1;
        }
        if (verif == 0) {
            return true;
        }
        JOptionPane.showMessageDialog(null, "Verfie!");
        return false;
    }

    @FXML
    private void Ajouterexercice(ActionEvent event) {
                if(verifUserChampsajouter()){
          Serviceexercice sp = new Serviceexercice();
        sp.ajouter(new exercice(nom.getText(), description.getText()));
        
        JOptionPane.showMessageDialog(null, "Exercice ajoutée !");
  view();
  viewid();}
    }

    @FXML
    private void menu(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

   