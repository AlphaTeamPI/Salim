/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.gui;

import com.esprit.gui.MenuController;
import com.esprit.models.Commande;
import com.esprit.services.ServiceCommande;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Iyed Zidi
 */
public class CommandeController implements Initializable {

    @FXML
    private TextField IdClient;
    @FXML
    private TextField dateC;
    @FXML
    private Button btn;
    @FXML
    private TableView<Commande> table;
    @FXML
    private TableColumn<Commande, Integer> idCommandea;
    @FXML
    private TableColumn<Commande, String> IdClienta;
    @FXML
    private TableColumn<Commande, Integer> datea;
    @FXML
    private TableColumn<Commande, Float> etata;
    @FXML
    private TableColumn<Commande, Integer> id_servicea;
    @FXML
    private TextField id_mod;
    @FXML
    private TextField validite1;
    @FXML
    private Button ok;
    @FXML
    private CheckBox ch1;
    @FXML
    private CheckBox ch;
    @FXML
    private TextField prix;
    @FXML
    private TextField type1;
    @FXML
    private TextField prix1;
    @FXML
    private ComboBox<Integer> id_sup;
    @FXML
    private TextField rechercher;
    @FXML
    private TextField id_service;
    @FXML
    private TextField id_service1;
    @FXML
    private TextField duree;
    @FXML
    private TextField duree1;
    @FXML
    private TableColumn<Commande, Integer> id_abon;

    public void view() {
        try {
            ServiceCommande sc = new ServiceCommande();

            ArrayList<Commande> lv;

            lv = (ArrayList<Commande>) sc.afficher();
            ObservableList<Commande> data = FXCollections.observableArrayList(lv);
            id_abon.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id"));
            dureea.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("duree"));
            typea.setCellValueFactory(new PropertyValueFactory<Commande, String>("typeService"));
            validitea.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("validite"));
            prixa.setCellValueFactory(new PropertyValueFactory<Commande, Float>("prix"));
            id_servicea.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("idService"));
            table.setItems(data);

        } catch (Exception ex) {
            Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        view();
        viewid();
        view();
        // search_user();
    }

    @FXML
    private void supprimer(ActionEvent event) {
        ServiceCommande sp = new ServiceCommande();
        Commande l = new Commande();

        l.setIdCommande((int) id_sup.getSelectionModel().getSelectedItem());
//        
        sp.supprimer(l);
        view();
        viewid();
    }

    @FXML
    private void modifier(ActionEvent event) {
        if (verifUserChampsmodifier()) {
            ServiceCommande sp = new ServiceCommande();
            String s = id_mod.getText();
            int si = Integer.parseInt(s);
            String s1 = validite1.getText();
            int si1 = Integer.parseInt(s1);
            String s0 = prix1.getText();
            Float si2 = Float.parseFloat(s0);
            String s2;
            s2 = duree1.getText();
            int si3 = Integer.parseInt(s2);
            String s3 = id_service1.getText();
            int si4 = Integer.parseInt(s3);
            //sp.modifier(new Commande(si,si3,type1.getText(),si1,si2,si4));

            JOptionPane.showMessageDialog(null, "Commande modifiée !");
            view();
        }
    }

    @FXML
    private void rechercher(ActionEvent event) {
        if (ch.isSelected()) {

            try {
                ServiceCommande sc = new ServiceCommande();

                ArrayList<Commande> lv;

                lv = (ArrayList<Commande>) sc.tridesc();
                ObservableList<Commande> data = FXCollections.observableArrayList(lv);
                id_abon.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id"));
                dureea.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("duree"));
                typea.setCellValueFactory(new PropertyValueFactory<Commande, String>("typeService"));
                validitea.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("validite"));
                prixa.setCellValueFactory(new PropertyValueFactory<Commande, Float>("prix"));
                id_servicea.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("idService"));
                table.setItems(data);

            } catch (Exception ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (ch1.isSelected()) {
            ch.setSelected(false);
            try {
                ServiceCommande sc = new ServiceCommande();

                ArrayList<Commande> lv;
                lv = (ArrayList<Commande>) sc.triasc();
                ObservableList<Commande> data = FXCollections.observableArrayList(lv);
                id_abon.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("id"));
                dureea.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("duree"));
                typea.setCellValueFactory(new PropertyValueFactory<Commande, String>("typeService"));
                validitea.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("validite"));
                prixa.setCellValueFactory(new PropertyValueFactory<Commande, Float>("prix"));
                id_servicea.setCellValueFactory(new PropertyValueFactory<Commande, Integer>("idService"));
                table.setItems(data);

            } catch (Exception ex) {
                Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
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
        if (verifUserChampsajouter()) {
            ServiceCommande sp = new ServiceCommande();
            String s1 = validite.getText();
            int si1 = Integer.parseInt(s1);
            String s0 = prix.getText();
            Float si2 = Float.parseFloat(s0);
            String s2 = duree.getText();
            int si3 = Integer.parseInt(s0);
            String s3 = id_service.getText();
            int si4 = Integer.parseInt(s3);
            //sp.ajouter(new Commande(si3, type.getText(),si1,si2,si4));

            JOptionPane.showMessageDialog(null, "Commande ajoutée !");
            view();
            //viewid();
        }

    }

    @FXML
    private void modify(MouseEvent event) {
        Commande r = table.getSelectionModel().getSelectedItem();
//        String id  = Integer.toString(r.getId());
//        id_mod.setText(id);
//        String duree  = Integer.toString(r.getDuree());
//        duree1.setText(duree);
//        type1.setText(r.getTypeService());
//        String validite = Integer.toString(r.getDuree());
//        validite1.setText(validite);
//        String prix = Float.toString(r.getPrix());
//        prix1.setText(prix);
//        String id_service = Integer.toString(r.getIdService());
//        id_service1.setText(id_service);

    }

    public void viewid() {
        ServiceCommande sc = new ServiceCommande();

        ArrayList lv;

        lv = (ArrayList) sc.afficherid();
        ObservableList data = FXCollections.observableArrayList(lv);
        id_sup.setItems(data);
    }

    public boolean verifUserChampsajouter() {
        int verif = 0;
        String style = " -fx-border-color: red;";

        String styledefault = "-fx-border-color: green;";

        duree.setStyle(styledefault);
        type.setStyle(styledefault);
        prix.setStyle(styledefault);
        validite.setStyle(styledefault);

        if (duree.getText().equals("")) {
            duree.setStyle(style);
            verif = 1;
        }

        if (type.getText().equals("")) {
            type.setStyle(style);
            verif = 1;
        }
        if (validite.getText().equals("")) {
            validite.setStyle(style);
            verif = 1;
        }
        if (prix.getText().equals("")) {
            prix.setStyle(style);
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

        duree1.setStyle(styledefault);
        type1.setStyle(styledefault);
        prix1.setStyle(styledefault);
        validite1.setStyle(styledefault);
        id_mod.setStyle(styledefault);
        if (duree1.getText().equals("")) {
            duree1.setStyle(style);
            verif = 1;
        }

        if (type1.getText().equals("")) {
            type1.setStyle(style);
            verif = 1;
        }
        if (validite1.getText().equals("")) {
            validite1.setStyle(style);
            verif = 1;
        }
        if (prix1.getText().equals("")) {
            prix1.setStyle(style);
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
//       void search_user() {
//ServiceCommande sc = new ServiceCommande();
//        
//
//           ArrayList<Commande> lv;
//            lv = (ArrayList<Commande>) sc.triasc();
//            ObservableList<Commande> data = FXCollections.observableArrayList(lv);;
//            id_abon.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("id"));
//            dureea.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("duree"));
//            typea.setCellValueFactory(new PropertyValueFactory<Commande,String>("typeService"));
//            validitea.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("validite"));
//            prixa.setCellValueFactory(new PropertyValueFactory<Commande,Float>("prix"));
//            id_servicea.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("idService"));
//        table.setItems(data);
//       
//        FilteredList<Commande> filteredData = new FilteredList<>(data, b -> true);
//       
//        rechercher.textProperty().addListener((observable, oldValue, newValue) -> {
//            filteredData.setPredicate((Commande person) -> {
//                if (newValue == null || newValue.isEmpty()) {
//                    return true;
//                }
//                String lowerCaseFilter = newValue.toLowerCase();
//
//                if (person.getTypeService().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true; // Filter matches username
//               
//                }

//                 else if (Integer.valueOf(person.getId_local()).equals(searchTerm.toLowerCase()) ) {
//                    return true;// Filter matches email
//              }
//                else {
//                    return false; // Does not match.
//                }
//            });
//        });
//        SortedList<Commande> sortedData = new SortedList<>(filteredData);
//        sortedData.comparatorProperty().bind(table.comparatorProperty());
//        table.setItems(sortedData);
//    }
}
