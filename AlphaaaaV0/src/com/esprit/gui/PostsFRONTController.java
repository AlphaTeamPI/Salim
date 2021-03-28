/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.GUI;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PostsFRONTController implements Initializable {

    @FXML
    private Button Btn_Ajout;
    @FXML
    private Button BtnMod;
    @FXML
    private Button Btn_Delete;
    @FXML
    private ComboBox<?> Btn_Sort;
    @FXML
    private TextField searchbar;
    @FXML
    private TableColumn<?, ?> col_user;
    @FXML
    private Button ajoutC;
    @FXML
    private Button ModC;
    @FXML
    private Button DelC;
    @FXML
    private Button ViewP;
    @FXML
    private Button ViewP1;
    @FXML
    private Button ViewP2;
    @FXML
    private ComboBox<?> Btn_Sort1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void SupprimerP(ActionEvent event) {
    }
    
}
