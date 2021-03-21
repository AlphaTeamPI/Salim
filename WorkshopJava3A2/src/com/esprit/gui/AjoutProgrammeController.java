/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.gui;


import com.esprit.models.programme;
import com.esprit.services.Serviceprogramme;
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
public class AjoutProgrammeController implements Initializable {

    @FXML
    private Button btn;
    @FXML  
    private TableView<programme> table;
    @FXML
    private TextField id_mod;
    @FXML
    private Button ok;
    @FXML
    private CheckBox ch1;
    @FXML
    private CheckBox ch;
    @FXML
    private TextField difficulte;
    @FXML
    private TextField type;
    @FXML
    private TableColumn<programme,Integer> dureea;
    @FXML
    private TableColumn<programme,Integer> progressiona;

    @FXML
    private TableColumn<programme,String> difficultea;
    @FXML
    private TableColumn<programme,String> typea;
    @FXML
    private TextField duree;
    @FXML
    private TextField progression;
    @FXML
    private TextField difficulte1;
    @FXML

    private TextField type1;

    @FXML
    private TableColumn<programme,Integer> id_programme;
    @FXML
    private TextField duree1;
    @FXML
    private TextField progression1;
    @FXML
    private ComboBox<Integer> id_sup;
    @FXML
    private TextField rechercher;
    
     
     public void view(){
         try {
            Serviceprogramme sc = new Serviceprogramme();
        

           ArrayList<programme> lv;
       
            lv = (ArrayList<programme>) sc.afficher();
            ObservableList<programme> data = FXCollections.observableArrayList(lv);
            id_programme.setCellValueFactory(new PropertyValueFactory<programme,Integer>("id"));
            difficultea.setCellValueFactory(new PropertyValueFactory<programme,String>("difficulte"));
            typea.setCellValueFactory(new PropertyValueFactory<programme,String>("type"));
            dureea.setCellValueFactory(new PropertyValueFactory<programme,Integer>("duree"));
            progressiona.setCellValueFactory(new PropertyValueFactory<programme,Integer>("progression"));
            table.setItems(data);
          
        } catch (Exception ex) {
            Logger.getLogger(AjoutProgrammeController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       view();
       viewid();
       search_user();
    }    
    @FXML
    private void supprimer(ActionEvent event) {
Serviceprogramme sp = new Serviceprogramme();
        programme l = new programme();

//    String id = gid.getText();
//        l.setId_membre(Integer.parseInt(id));
        l.setId((int) id_sup.getSelectionModel().getSelectedItem());
        
        sp.supprimer(l);
        view();
        viewid();
    }

    @FXML
    private void modifier(ActionEvent event) {
        if(verifUserChampsmodifier()){
        Serviceprogramme sp = new Serviceprogramme();
          String s=id_mod.getText();
          int si=Integer.parseInt(s);
          String s1=duree1.getText();
          int si1=Integer.parseInt(s1);
          String s0=progression1.getText();
          int si2=Integer.parseInt(s0);
        sp.modifier(new programme(si,difficulte1.getText(),type1.getText(),si1,si2));
        
        JOptionPane.showMessageDialog(null, "Programme modifiée !");
        view();}
    }


    @FXML
    private void rechercher(ActionEvent event) {
        if(ch.isSelected()){
           
        try {
            Serviceprogramme sc = new Serviceprogramme();
        

           ArrayList<programme> lv;


            lv = (ArrayList<programme>) sc.tridesc();
            ObservableList<programme> data = FXCollections.observableArrayList(lv);
            id_programme.setCellValueFactory(new PropertyValueFactory<programme,Integer>("id"));
            difficultea.setCellValueFactory(new PropertyValueFactory<programme,String>("difficulte"));
            typea.setCellValueFactory(new PropertyValueFactory<programme,String>("type"));
            dureea.setCellValueFactory(new PropertyValueFactory<programme,Integer>("duree"));
            progressiona.setCellValueFactory(new PropertyValueFactory<programme,Integer>("progression"));
            table.setItems(data);
          
        } catch (Exception ex) {
            Logger.getLogger(AjoutProgrammeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
  if(ch1.isSelected()){
    ch.setSelected(false);
        try {
            Serviceprogramme sc = new Serviceprogramme();
        

           ArrayList<programme> lv;
            lv = (ArrayList<programme>) sc.triasc();
            ObservableList<programme> data = FXCollections.observableArrayList(lv);
          id_programme.setCellValueFactory(new PropertyValueFactory<programme,Integer>("id"));
            difficultea.setCellValueFactory(new PropertyValueFactory<programme,String>("difficulte"));
            typea.setCellValueFactory(new PropertyValueFactory<programme,String>("type"));
            dureea.setCellValueFactory(new PropertyValueFactory<programme,Integer>("duree"));
            progressiona.setCellValueFactory(new PropertyValueFactory<programme,Integer>("progression"));
            table.setItems(data);
          
        } catch (Exception ex) {
            Logger.getLogger(AjoutProgrammeController.class.getName()).log(Level.SEVERE, null, ex);
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
    private void Ajouterpersonne(ActionEvent event) {
        if(verifUserChampsajouter()){
          Serviceprogramme sp = new Serviceprogramme();
        String s=duree.getText();
          int si=Integer.parseInt(s);
          String s1=progression.getText();
          int si1=Integer.parseInt(s);
        sp.ajouter(new programme(difficulte.getText(), type.getText(),si,si1));
        
        JOptionPane.showMessageDialog(null, "Programme ajoutée !");
  view();
  viewid();}
  
    }

    @FXML
    private void modify(MouseEvent event) {
        programme r = table.getSelectionModel().getSelectedItem();
        String id  = Integer.toString(r.getId());
        id_mod.setText(id);
        difficulte1.setText(r.getDifficulte());
        type1.setText(r.getType());
        String duree = Integer.toString(r.getDuree());
        duree1.setText(duree);
        String calories = Integer.toString(r.getProgression());
        progression1.setText(calories);

    }
     public void viewid(){
   Serviceprogramme sc = new Serviceprogramme();
        

           ArrayList lv;
       
            lv = (ArrayList) sc.afficherid();
            ObservableList data = FXCollections.observableArrayList(lv);
        id_sup.setItems(data);
     }
     public boolean verifUserChampsajouter() {
        int verif = 0;
        String style = " -fx-border-color: red;";

        String styledefault = "-fx-border-color: green;";

   
       
        difficulte.setStyle(styledefault);
        type.setStyle(styledefault);
        progression.setStyle(styledefault);
        duree.setStyle(styledefault);


 

        if (difficulte.getText().equals("")) {
            difficulte.setStyle(style);
            verif = 1;
        }
       
        if (type.getText().equals("")) {
            type.setStyle(style);
            verif = 1;
        }
        if (duree.getText().equals("")) {
            duree.setStyle(style);
            verif = 1;
        }
           if (progression.getText().equals("")) {
            progression.setStyle(style);
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

   
       
        difficulte1.setStyle(styledefault);
        type1.setStyle(styledefault);
        progression1.setStyle(styledefault);
        duree1.setStyle(styledefault);
        id_mod.setStyle(styledefault);
        if (difficulte1.getText().equals("")) {
            difficulte1.setStyle(style);
            verif = 1;
        }
       
        if (type1.getText().equals("")) {
            type1.setStyle(style);
            verif = 1;
        }
        if (duree1.getText().equals("")) {
            duree1.setStyle(style);
            verif = 1;
        }
           if (progression1.getText().equals("")) {
            progression1.setStyle(style);
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
    private void menu(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Menu.fxml"));/* Exception */
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
       @FXML
 void search_user() {
Serviceprogramme sc = new Serviceprogramme();
        

           ArrayList<programme> lv;
            lv = (ArrayList<programme>) sc.triasc();
            ObservableList<programme> data = FXCollections.observableArrayList(lv);;
          id_programme.setCellValueFactory(new PropertyValueFactory<programme,Integer>("id"));
            difficultea.setCellValueFactory(new PropertyValueFactory<programme,String>("difficulte"));
            typea.setCellValueFactory(new PropertyValueFactory<programme,String>("type"));
            dureea.setCellValueFactory(new PropertyValueFactory<programme,Integer>("duree"));
            progressiona.setCellValueFactory(new PropertyValueFactory<programme,Integer>("progression"));


       
        table.setItems(data);
       
        FilteredList<programme> filteredData = new FilteredList<>(data, b -> true);
       
        rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((programme person) -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String lowerCaseFilter = newValue.toLowerCase();

                if (person.getDifficulte().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches username
               
                } else if (person.getType().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches password
                        }
               
//                 else if (Integer.valueOf(person.getId_local()).equals(searchTerm.toLowerCase()) ) {
//                    return true;// Filter matches email
//              }
                else {
                    return false; // Does not match.
                }
            });
        });
        SortedList<programme> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(table.comparatorProperty());
        table.setItems(sortedData);
    }
}

   