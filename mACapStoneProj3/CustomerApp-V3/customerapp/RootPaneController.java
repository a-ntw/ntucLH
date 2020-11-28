/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab; 
import javafx.scene.control.TabPane;

public class RootPaneController implements Initializable{

    @FXML private TabPane bankCustomer;

    //###################################Inject part#############################################
    // Inject tab content
    @FXML private Tab cListRef; //from TabPaneRootView.fxml: <Tab fx:id="tab1_foo" ...>
    @FXML private Tab cOpsRef; //from TabPaneRootView.fxml: <Tab fx:id="tab2_bar" ...>

    // Inject tab controller
    @FXML private cListController cListController;//TabPaneRootView.fxml_include_fx:id="xxx_tab1foo_xxx" + "Controller"
    @FXML private cOpsController cOpsController;//TabPaneRootView.fxml_include_fx:id="xxx_tab2bar_xxx" + "Controller"
   //###########################################################################################

     public void init() {
               bankCustomer.getSelectionModel().selectedItemProperty().addListener((ObservableValue<? extends Tab> observable,Tab oldValue, Tab newValue) -> {                                                                                                    
            if (newValue == cOpsRef) {
                System.out.println("Customer Ops Controller =" + cListController); //if =null => inject problem 
                cOpsController.handleTab2ButtonBar();
            } else if (newValue == cListRef) {
                System.out.println("Customer List Controller = " + cOpsController); //if =null => inject problem
                cListController.init();
            } else {
                System.out.println("- another Tab -");
            }
        });
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
     }
}