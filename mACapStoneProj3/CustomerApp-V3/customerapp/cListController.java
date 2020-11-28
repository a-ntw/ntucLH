/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author chand
 */
public class cListController implements Initializable {

    @FXML
    private TableView<Customer> cListTbl;
    @FXML
    private TableColumn<Customer, Integer> custID;
    @FXML
    private TableColumn<Customer, String> custName;
    @FXML
    private TableColumn<Customer, LocalDate> DOB;
    @FXML
    private TableColumn<Customer, String> email;
    @FXML
    private TableColumn<Customer, String> phoneNo;
    @FXML
    private TableColumn<Customer, Boolean> Active;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    public  void init() {
         try {
            
            cListTbl.setStyle("-fx-alignment: CENTER-LEFT;");
            custID.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("custID"));
            custName.setCellValueFactory(new PropertyValueFactory<Customer, String>("custName"));
            DOB.setCellValueFactory(new PropertyValueFactory<Customer, LocalDate>("DOB"));
            email.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
            phoneNo.setCellValueFactory(new PropertyValueFactory<Customer, String>("phoneNo"));
            Active.setCellValueFactory(new PropertyValueFactory<Customer, Boolean>("isActive"));
            
          cListTbl.setItems(CustomerDAO.listCustomers());    
        }catch(Exception e){
            System.out.println(" Exception in CustomerListFXML Controller " + e.getMessage());
            e.printStackTrace();
        }
         
    }    

    
}
