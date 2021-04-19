/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import Alert.AlertDialog;
import Service.Abonnement_Service;
import Service.Categorie_Service;
import Service.Site_Service;
import Service.Velo_Service;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import entites.Session;
import entites.User;
import entites.Velo;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author aymen
 */
public class home_VeloController implements Initializable {

    @FXML
    private VBox vboxdrawer;
    @FXML
    private ImageView imagechange;
    @FXML
    private Label fullName;
    @FXML
    private Button btn_affichage;
    @FXML
    private Button btn_back;
    @FXML
    private Button btnSignout;
    @FXML
    private Pane pnl_abonnement;
    @FXML
    private TextField txt_Seach;
    @FXML
    private TableView<Velo> tabview;
    @FXML
    private TableColumn<Velo, String> col_libelle;
    @FXML
    private TableColumn<Velo, String> col_categorie;
    @FXML
    private TableColumn<Velo, String> col_site;
    @FXML
    private TableColumn<Velo, String> col_description;
    @FXML
    private TableColumn<Velo, Float> col_prix;
    @FXML
    private TableColumn<Velo, String> col_type;
    @FXML
    private TableColumn<Velo, Integer> col_age;
    @FXML
    private TableColumn<Velo, String> col_couleur;
    @FXML
    private TableColumn<Velo, Integer> col_id;
    @FXML
    private TextField txt_libelle;
    @FXML
    private TextField txt_prix;
    @FXML
    private TextField txt_description;
    @FXML
    private ComboBox<String> combo_categorie;
    @FXML
    private ComboBox<String> combo_site;
    @FXML
    private Button btn_velo;
    @FXML
    private Button pdf;
    @FXML
    private Button stat;
    @FXML
    private ImageView imageview;
    @FXML
    private TextField txt_type;
    @FXML
    private TextField txt_age;
    @FXML
    private TextField txt_couleur;
    @FXML
    private ImageView Image_Velo;
private TableColumn<Velo, String> col_btnDelet;
    private Velo_Service service = new Velo_Service();
       private Categorie_Service serviceCatgorie = new Categorie_Service();
    private Site_Service servicesite = new Site_Service();
    private User usersession = Session.get();
        private String nomImage = "";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tabview.setEditable(true);
         setCellfromtabletoImage();
         Modifier();
        search();
        try {
            refreche();
        } catch (SQLException ex) {
            Logger.getLogger(home_VeloController.class.getName()).log(Level.SEVERE, null, ex);
        }
         combo_categorie.setItems(serviceCatgorie.get_List_Categories_Velo());
        combo_site.setItems(servicesite.get_List_sites());
        combo_categorie.getSelectionModel().select(0);
        combo_site.getSelectionModel().select(0);
        col_btnDelet = new TableColumn("Supprimer");
             String ImageUrl ="http://localhost/bike/web/uploads/images/";
        Image image = new Image(ImageUrl + usersession.getImage());

        imagechange.setImage(image);
              fullName.setText(usersession.getFname() + " " + usersession.getLname());
              
                 javafx.util.Callback<TableColumn<Velo, String>, TableCell<Velo, String>> cellFactory
                = new Callback<TableColumn<Velo, String>, TableCell<Velo, String>>() {
            public TableCell call(final TableColumn<Velo, String> param) {
                final TableCell<Velo, String> cell = new TableCell<Velo, String>() {

                    final Button btn = new Button("supprimer");

                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            btn.setOnAction(event -> {
                                Velo u = getTableView().getItems().get(getIndex());
 File f = new File("C:/xampp/htdocs/bike/web/uploads/images/"+u.getImage());
                            
                                System.out.println(f.delete());                             

                          
                              
                                try {
                                    service.Supprimer(u.getId_v());
                                } catch (SQLException ex) {
                                    Logger.getLogger(home_VeloController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                               
                                AlertDialog.showNotification("suppression confirmée!", "suppression a été bien faite", AlertDialog.image_checked);

                                try {
                                    refreche();
                                } catch (SQLException ex) {
                                    Logger.getLogger(home_AbonemetController.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            });
                            setGraphic(btn);
                            setText(null);
                        }
                    }
                };
                return cell;
            }
        };
        col_btnDelet.setCellFactory(cellFactory);
        tabview.getColumns().add(col_btnDelet);
        
    }    
       public void search() {
        txt_Seach.setOnKeyReleased(e
                -> {
            if (txt_Seach.getText().equals("")) {

                try {
                    refreche();
                } catch (SQLException ex) {
                    Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            } else {

                try {
                    col_libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
                    col_categorie.setCellValueFactory(new PropertyValueFactory<>("Lib_C"));
                    col_site.setCellValueFactory(new PropertyValueFactory<>("Lib_S"));
                    col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
                    col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
                    col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
                    col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
                    col_couleur.setCellValueFactory(new PropertyValueFactory<>("couleur"));
                    col_id.setCellValueFactory(new PropertyValueFactory<>("id_v"));
                    tabview.getItems().clear();

                    tabview.setItems(service.serach(txt_Seach.getText()));

                } catch (SQLException ex) {
                    Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
        );

    }

 
   public void refreche() throws SQLException {
        col_libelle.setCellValueFactory(new PropertyValueFactory<>("libelle"));
         col_libelle.setCellFactory(TextFieldTableCell.<Velo> forTableColumn());
        col_categorie.setCellValueFactory(new PropertyValueFactory<>("Lib_C"));
        col_categorie.setCellFactory(TextFieldTableCell.<Velo> forTableColumn());
        col_site.setCellValueFactory(new PropertyValueFactory<>("Lib_S"));
            col_site.setCellFactory(TextFieldTableCell.<Velo> forTableColumn());
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
              col_description.setCellFactory(TextFieldTableCell.<Velo> forTableColumn());
        col_prix.setCellValueFactory(new PropertyValueFactory<>("prix"));
          col_prix.setCellFactory(TextFieldTableCell.forTableColumn(new FloatStringConverter()));
        col_type.setCellValueFactory(new PropertyValueFactory<>("type"));
        col_type.setCellFactory(TextFieldTableCell.<Velo> forTableColumn());
        col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
             col_age.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col_couleur.setCellValueFactory(new PropertyValueFactory<>("couleur"));
                   col_couleur.setCellFactory(TextFieldTableCell.<Velo> forTableColumn());
              col_id.setCellValueFactory(new PropertyValueFactory<>("id_v"));
        tabview.getItems().clear();
        tabview.setItems(service.Affichertout());

    }
    @FXML
    private void handleClicks(ActionEvent event) throws IOException {
         if (event.getSource() == btn_back) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/page_admin.fxml")));
            stage.setScene(scene);
            stage.show();

        }
        if (event.getSource() == btnSignout) {
            Node node = (Node) event.getSource();

            Stage stage = (Stage) node.getScene().getWindow();
            //stage.setMaximized(true);
            stage.close();
            Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Login.fxml")));
            stage.setScene(scene);
            stage.show();
        }
    }

    @FXML
    private void ajouter_velo(ActionEvent event) throws SQLException {
        
         if (txt_libelle.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de libelle", AlertDialog.image_cross);
        } else if (txt_libelle.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Erreur txt_libelle !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
        } else if (txt_prix.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de Prix", AlertDialog.image_cross);
        }
        else if (txt_prix.getText().matches("^[a-zA-Z]+$")) {
            AlertDialog.showNotification("Erreur Prix !", "Prix incorrect", AlertDialog.image_cross);
        }
        else if (Float.valueOf(txt_prix.getText()) <= 0) {
            AlertDialog.showNotification("Error !", "Champ de Prix", AlertDialog.image_cross);
        }  else if (txt_type.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de Type", AlertDialog.image_cross);
        } else if (txt_type.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Erreur Type !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
        } else if (txt_couleur.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de Couleur", AlertDialog.image_cross);
        } else if (txt_couleur.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Erreur Couleur !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
        } else if (txt_description.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de Description", AlertDialog.image_cross);
        } else if (txt_description.getText().matches("^[0-9]+$")) {
            AlertDialog.showNotification("Erreur Description !", "il faut saisir des caracteres  !", AlertDialog.image_cross);
        } else if (txt_age.getText().equals("")) {
            AlertDialog.showNotification("Error !", "Champ vide de age", AlertDialog.image_cross);
        }  else if (txt_age.getText().matches("^[a-zA-Z]+$")) {
            AlertDialog.showNotification("Erreur age !", "Prix incorrect", AlertDialog.image_cross);
        } 
        else if (Integer.valueOf(txt_age.getText()) <= 0) {
            AlertDialog.showNotification("Error !", "Champ de age", AlertDialog.image_cross);
        }
        
        else if (nomImage.equals("")) {
            AlertDialog.showNotification("Erreur Image !", "Il faut inserer une photo", AlertDialog.image_cross);
        } else {
            String code =Abonnement_Service.getMd5(txt_libelle.getText()+ txt_description.getText())+nomImage;
           Velo Veloajouter = new Velo(txt_type.getText(), Integer.parseInt(txt_age.getText()), txt_couleur.getText(), "non reserve", txt_libelle.getText(), combo_categorie.getSelectionModel().getSelectedItem(), combo_site.getSelectionModel().getSelectedItem(), code, txt_description.getText(), Float.parseFloat(txt_prix.getText()));
  InputStream inStream = null;
    OutputStream outStream = null;

        try{

            File afile =new File("./src/images/"+nomImage);
            File bfile =new File("C:/xampp/htdocs/bike/web/uploads/images/"+code);
            

            inStream = new FileInputStream(afile);
            outStream = new FileOutputStream(bfile);

            byte[]buffer = new byte[1024];

            int length;
           //copy the file content in bytes
            while ((length = inStream.read(buffer)) > 0){

                outStream.write(buffer, 0, length);

            }

            inStream.close();
            outStream.close();

            System.out.println("File is copied successful!");

        }catch(IOException e){
            e.printStackTrace();
        }
            
            service.Ajouter(Veloajouter);
            refreche();
        }
        
        
        
        
        
        
    }

    @FXML
    private void fairepdf(ActionEvent event) {
           Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream("Velos.pdf"));
            document.open();
            Paragraph ph1 = new Paragraph("Bienvenue a Bike !");
            Paragraph ph2 = new Paragraph(".");
            PdfPTable table = new PdfPTable(9);
         
     com.itextpdf.text.Image    image1 =  com.itextpdf.text.Image.getInstance("/Users/aymen/Desktop/projet_Bike_Desktop/src/images/logo_bike.png" );
   
    //Scale to new height and new width of image
    image1.scaleAbsolute(200, 200);
    //Add to document
    document.add(image1);
   
            //On créer l'objet cellule.
            PdfPCell cell;
           
            //contenu du tableau.
            table.addCell("Libelle : ");
            table.addCell("Prix : ");
            table.addCell("Type : ");
            table.addCell("Age : ");
            table.addCell("Couleur : ");
            table.addCell("Etat : ");
            table.addCell("Categorie :");
            table.addCell("Site : ");
            table.addCell("Image : ");
             
            service.Affichertout().forEach(e
                    -> {
                 table.addCell(e.getLibelle());
             
		table.setHorizontalAlignment(Element.ALIGN_CENTER);

               
                table.addCell(String.valueOf(e.getPrix()));
                table.addCell(e.getType());
                table.addCell(String.valueOf(e.getAge()));
                   table.addCell(e.getCouleur());
                      table.addCell(e.getEtat());
                table.addCell(e.getLib_C());
                table.addCell(e.getLib_S());
                try {
                    com.itextpdf.text.Image    image_table =  com.itextpdf.text.Image.getInstance("/xampp/htdocs/bike/web/uploads/images/"+e.getImage() );
                    image_table.scaleAbsolute(200, 200);
   table.addCell(image_table);
                } catch (BadElementException ex) {
                    Logger.getLogger(home_AbonemetController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(home_AbonemetController.class.getName()).log(Level.SEVERE, null, ex);
                }
   
    //Scale to new height and new width of image

    //Add to document

             
            }
            );
            document.add(ph1);
            document.add(ph2);
            document.add(table);
            document.addAuthor("Bike");
            AlertDialog.showNotification("Creation PDF ", "Votre fichier PDF a ete cree avec success", AlertDialog.image_checked);
        } catch (Exception e) {
            System.out.println(e);
        }
        document.close();
    }

    @FXML
    private void faire_stat(ActionEvent event) {
         Scene scene;
        Stage stage = new Stage();
        try {

            scene = new Scene(FXMLLoader.load(getClass().getResource("/GUI/Statistique_Velo.fxml")));
            stage.setScene(scene);
            stage.setTitle("Statistique Velo");
            stage.show();

        } catch (IOException ex) {
            Logger.getLogger(homeController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private void setCellfromtabletoImage() {
        tabview.setOnMouseClicked(e -> {

            Velo ac = tabview.getItems().get(tabview.getSelectionModel().getSelectedIndex());
            String ImageUrl ="http://localhost/bike/web/uploads/images/";
        

        Image image = new Image(ImageUrl + ac.getImage());
        Image_Velo.setImage(image);
        }
        );

    }
    @FXML
    private void handleDragOver(DragEvent event) {
          if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.ANY);
        }
    }

    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
          List<File> files = event.getDragboard().getFiles();
        Image img = new Image(new FileInputStream(files.get(0)));
        imageview.setImage(img);
        nomImage = files.get(0).getName();
    }
    
                public void Modifier()
    {
         
                   
                  
                   
            
        
               
                col_libelle.setOnEditCommit((TableColumn.CellEditEvent<Velo, String> event) -> {
            TablePosition<Velo, String> pos = event.getTablePosition();
                
            String libelle_Ac = event.getNewValue();
                 
            int row = pos.getRow();
            Velo ac = event.getTableView().getItems().get(row);
           
  
            ac.setLibelle(libelle_Ac);
                    try {
                        service.Modifier(ac,ac.getId_v());
                    } catch (SQLException ex) {
                        Logger.getLogger(home_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });
                
                
            col_categorie.setOnEditCommit((TableColumn.CellEditEvent<Velo, String> event) -> {
            TablePosition<Velo, String> pos = event.getTablePosition();
           
            String Categorie_Ab = event.getNewValue();
                  
            int row = pos.getRow();
            Velo ab = event.getTableView().getItems().get(row);
          
  
            ab.setLib_C(Categorie_Ab);
                    try {
                        service.Modifier(ab,ab.getId_v());
                    } catch (SQLException ex) {
                        Logger.getLogger(home_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });      
              col_site.setOnEditCommit((TableColumn.CellEditEvent<Velo, String> event) -> {
            TablePosition<Velo, String> pos = event.getTablePosition();
           
            String Site_Ab = event.getNewValue();
                  
            int row = pos.getRow();
            Velo ab = event.getTableView().getItems().get(row);
          
  
            ab.setLib_S(Site_Ab);
                    try {
                        service.Modifier(ab,ab.getId_v());
                    } catch (SQLException ex) {
                        Logger.getLogger(home_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });       
              
              
              
                        col_description.setOnEditCommit((TableColumn.CellEditEvent<Velo, String> event) -> {
            TablePosition<Velo, String> pos = event.getTablePosition();
           
            String Description_Ab = event.getNewValue();
                  
            int row = pos.getRow();
            Velo ab = event.getTableView().getItems().get(row);
          
  
            ab.setDescription(Description_Ab);
                    try {
                        service.Modifier(ab,ab.getId_v());
                    } catch (SQLException ex) {
                        Logger.getLogger(home_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });       
         col_type.setOnEditCommit((TableColumn.CellEditEvent<Velo, String> event) -> {
            TablePosition<Velo, String> pos = event.getTablePosition();
           
            String type_Ab = event.getNewValue();
                  
            int row = pos.getRow();
            Velo ab = event.getTableView().getItems().get(row);
          
  
            ab.setType(type_Ab);
                    try {
                        service.Modifier(ab,ab.getId_v());
                    } catch (SQLException ex) {
                        Logger.getLogger(home_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });   

   col_couleur.setOnEditCommit((TableColumn.CellEditEvent<Velo, String> event) -> {
            TablePosition<Velo, String> pos = event.getTablePosition();
           
            String couleur_Ab = event.getNewValue();
                  
            int row = pos.getRow();
            Velo ab = event.getTableView().getItems().get(row);
          
  
            ab.setCouleur(couleur_Ab);
                    try {
                        service.Modifier(ab,ab.getId_v());
                    } catch (SQLException ex) {
                        Logger.getLogger(home_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });    
  
     col_age.setOnEditCommit((TableColumn.CellEditEvent<Velo, Integer> event) -> {
            TablePosition<Velo, Integer> pos = event.getTablePosition();
           
            Integer age_Ab = event.getNewValue();
                  
            int row = pos.getRow();
            Velo ab = event.getTableView().getItems().get(row);
          
  
            ab.setAge(age_Ab);
                    try {
                        service.Modifier(ab,ab.getId_v());
                    } catch (SQLException ex) {
                        Logger.getLogger(home_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });  
     
     col_prix.setOnEditCommit((TableColumn.CellEditEvent<Velo, Float> event) -> {
            TablePosition<Velo, Float> pos = event.getTablePosition();
           
            Float Prix_Ab = event.getNewValue();
                  
            int row = pos.getRow();
            Velo ab = event.getTableView().getItems().get(row);
          
  
            ab.setPrix(Prix_Ab);
                    try {
                        service.Modifier(ab,ab.getId_v());
                    } catch (SQLException ex) {
                        Logger.getLogger(home_CategorieController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        });
     
     
     
                
    }

 
    
}