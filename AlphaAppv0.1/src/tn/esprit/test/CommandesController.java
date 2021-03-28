/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tn.esprit.test;

import java.io.IOException;
import tn.esprit.models.Commande;
import tn.esprit.services.ServiceCommande;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
//import javafx.collections.transformation.FilteredList;
//import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import tn.esprit.gui.MenuBackendController;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class CommandesController implements Initializable {

    @FXML
    private Button btn;
    @FXML
    private TableView<Commande> table;
    @FXML
    private TextField idC;
    @FXML
    private TextField etatC1;
    @FXML
    private Button ok;
    @FXML
    private CheckBox asc;
    @FXML
    private CheckBox desc;
    @FXML
    private TextField etatC;
    @FXML
    private TextField montantC;
    @FXML
    private TextField montantC1;
    @FXML
    private ComboBox<?> id_sup;
    @FXML
    private TextField rechercher;
    @FXML
    private ComboBox<?> idClient;
    @FXML
    private DatePicker dateC;
    @FXML
    private DatePicker dateC1;
    @FXML
    private TableColumn<Commande, Integer> IdCommande;
    @FXML
    private TableColumn<Commande, Integer> IdClient;
    @FXML
    private TableColumn<Commande, DatePicker> datea;
    @FXML
    private TableColumn<Commande, String> etata;
    @FXML
    private TableColumn<Commande, Float> montanta;

    public void view(){
         try {
            ServiceCommande sc = new ServiceCommande();
        

           ArrayList<Commande> lv;
       
            lv = (ArrayList<Commande>) sc.afficher();
            ObservableList<Commande> data = FXCollections.observableArrayList(lv);
            IdCommande.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("IdCommande"));
            IdClient.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("IdClient"));
            datea.setCellValueFactory(new PropertyValueFactory<Commande,DatePicker>("DateCom"));
            etata.setCellValueFactory(new PropertyValueFactory<Commande,String>("EtatCom"));
            montanta.setCellValueFactory(new PropertyValueFactory<Commande,Float>("MontantCom"));
            table.setItems(data);
          
        } catch (Exception ex) {
            Logger.getLogger(MenuBackendController.class.getName()).log(Level.SEVERE, null, ex);
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
       //search();
    }

    public void viewid(){
        ServiceCommande sc = new ServiceCommande();
        ArrayList lv;
        lv = (ArrayList) sc.afficherid();
        ObservableList data = FXCollections.observableArrayList(lv);
        id_sup.setItems(data);
     }
    
    @FXML
    private void Ajouter(ActionEvent event) {
        ServiceCommande sc = new ServiceCommande();
          String s0=IdClient.getText();
          int si0=Integer.parseInt(s0);
          LocalDate d1= dateC.getValue();
          Date datex = Date.valueOf(d1);
          String s1=etatC.getText();
          String s2=montantC.getText();
          Float si2=Float.parseFloat(s2);
        sc.ajouter(new Commande(si0,datex,si2,s1));
        
        JOptionPane.showMessageDialog(null, "Commande ajoutée !");
  view();
    }

    @FXML
    private void modify(MouseEvent event) {
    }

    @FXML
    private void supprimer(ActionEvent event) {
    }

    @FXML
    private void modifier(ActionEvent event) {
    }

    @FXML
    private void rechercher(ActionEvent event) {
    }

    @FXML
    private void asc(ActionEvent event) {
        asc.setSelected(false);
    }

    @FXML
    private void desc(ActionEvent event) {
        desc.setSelected(false);
    }

    @FXML
    private void menuBackend(ActionEvent event) throws IOException {
        Node node = (Node) event.getSource();
        Stage stage = (Stage) node.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("MenuBackend.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
//    void search() {
//        ServiceCommande sc = new ServiceCommande();
//        ArrayList<Commande> lv;
//        lv = (ArrayList<Commande>) sc.triasc();
//        ObservableList<Commande> data = FXCollections.observableArrayList(lv);
//        IdCommande.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("IdCommande"));
//        IdClient.setCellValueFactory(new PropertyValueFactory<Commande,Integer>("IdClient"));
//        datea.setCellValueFactory(new PropertyValueFactory<Commande,DatePicker>("DateCom"));
//        etata.setCellValueFactory(new PropertyValueFactory<Commande,String>("EtatCom"));
//        montanta.setCellValueFactory(new PropertyValueFactory<Commande,Float>("MontantCom"));
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
//                if (person.get().toLowerCase().indexOf(lowerCaseFilter) != -1) {
//                    return true; // Filter matches username
//               
//                }
//               
////                 else if (Integer.valueOf(person.getId_local()).equals(searchTerm.toLowerCase()) ) {
////                    return true;// Filter matches email
////              }
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
