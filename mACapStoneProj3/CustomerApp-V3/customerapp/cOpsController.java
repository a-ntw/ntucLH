/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

/**
 * FXML Controller class
 *
 * @author chand
 */
public class cOpsController implements Initializable {

    private static int status = 0;
    private Customer cust;

    @FXML
    private TextField custID;
    @FXML
    private TextField custName;
    @FXML
    private DatePicker DOB;
    @FXML
    private TextField email;
    @FXML
    private TextField phoneNo;

    @FXML
    private Pane dataPane;
    @FXML
    private CheckBox active;
    @FXML
    private Button submitBtn;
    @FXML
    private Button fetchDetails;
    @FXML
    private Button cancelBtn;

    public void handleTab2ButtonBar() {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void onCancel(ActionEvent event) {
        reset();
    }

    private void reset() {
        disableAll();
    }

    @FXML
    private void onSubmit(ActionEvent event) throws Exception {
        if (status == 1) {
            cust = new Customer(Integer.parseInt(custID.getText()), custName.getText(),
                    DOB.getValue(),
                    email.getText(), phoneNo.getText(), ((active.isSelected()) ? (byte) 1 : (byte) 0));
            CustomerDAO.insertCustomer(cust);
            cust = null;
            submitBtn.setDisable(true);
            showDialog(" Insert Operation", " Success ");
            reset();
            custName.setPromptText(" ");
            email.setPromptText(" ");
            phoneNo.setPromptText(" ");
            DOB.setPromptText(" ");
        } else if (status == 3) {
            cust.setDOB(DOB.getValue());
            cust.setEmail(email.getText());
            cust.setActive((active.isSelected()) ? (byte) 1 : (byte) 0);
            cust.setPhoneNo(phoneNo.getText());
            if (CustomerDAO.updateCustomer(cust)) {
                showDialog(" Status ", " Update Success ");
            }
            status = 0;
            disableAll();
            reset();
        } else if (status ==4){
             if (CustomerDAO.delCustomer(cust.getCustID())) { 
                showDialog(" Status Msg !!!", " Delete Success ");
            }
        }
    }

    private void showDialog(String title, String msg) {
        Dialog<String> dialog = new Dialog<String>();
        dialog.setTitle(title);
        ButtonType type = new ButtonType("Ok", ButtonData.OK_DONE);
        dialog.setContentText(msg);
        dialog.getDialogPane().getButtonTypes().add(type);
        dialog.showAndWait();
    }

    @FXML
    private void onInsert(ActionEvent event) {
        status = 1;
        disableAll();
        submitBtn.setText(" Insert Customer ");
        cancelBtn.setText(" Cancel / Reset ");
        custID.setText(CustomerDAO.getNextID() + "");
        custName.setPromptText(" Enter Customer Name");
        email.setPromptText(" Enter Email Address");
        phoneNo.setPromptText(" Phone No ... ");
        DOB.setPromptText(" Date of Birth ");
        enableAll();
    }

    @FXML
    private void onUpdate(ActionEvent event) {
        status = 2;
        disableAll();
        enableAll();
        fetchDetails.setDisable(false);
        custID.setDisable(false);
        custID.setEditable(true);
        custID.setPromptText("Enter CustID here...");
    }

    @FXML
    private void onDelete(ActionEvent event) {
        status = 4;
        disableAll();
         enableAll();
        fetchDetails.setDisable(false);
        custID.setDisable(false);
        custID.setEditable(true);
        custID.setPromptText("Enter CustID here...");
    }

    @FXML
    private void onReset(ActionEvent event) {
        status = 0;
        disableAll();
    }

    @FXML
    private void fetchDetails(ActionEvent event) throws Exception {
        if(status == 2)
            status = 3;
        int cID = Integer.parseInt(custID.getText());
        enableAll();
        cust = CustomerDAO.getCustomer(cID);
        if (cust == null) {
            showDialog(" Fetch Customer Details ", " Customer Not Found");
            onUpdate(event);
            return;
        }
        custName.setText(cust.getCustName());
        DOB.setValue(cust.getDOB());
        phoneNo.setText(cust.getPhoneNo());
        email.setText(cust.getEmail());
        active.setSelected(cust.getActive() == 1 ? true : false);
    }

    private void disableAll() {
        cancelBtn.setDisable(true);
        submitBtn.setDisable(true);
        custName.setDisable(true);
        DOB.setDisable(true);
        active.setDisable(true);
        phoneNo.setDisable(true);
        email.setDisable(true);
        cancelBtn.setDisable(true);
        submitBtn.setDisable(true);
        submitBtn.setText(" Submit ");
        cancelBtn.setText(" Cancel");
        resetAll();
    }
    
    private void resetAll(){
        custID.setText("");
        custName.setText("");
        DOB.setPromptText("Select DoB");
        phoneNo.setText("");
        email.setText("");
        active.setSelected(false);
    }

    private void enableAll() {

        dataPane.setDisable(false);
        if (status == 1) {
            cancelBtn.setDisable(false);
            submitBtn.setDisable(false);
            custID.setDisable(true);
            custName.setDisable(false);
            DOB.setDisable(false);
            active.setDisable(false);
            phoneNo.setDisable(false);
            email.setDisable(false);
        } else if (status == 2) {
            submitBtn.setText(" Update Customer ");
            submitBtn.setDisable(true);
            cancelBtn.setText(" Cancel / Reset ");
            cancelBtn.setDisable(true);
            email.setDisable(true);
            phoneNo.setDisable(true);
            DOB.setDisable(true);
            active.setDisable(true);
            custID.setDisable(false);
            custName.setDisable(true);
            cancelBtn.setDisable(true);
            submitBtn.setDisable(true);
        } else if (status == 3) {
            submitBtn.setDisable(false);
            cancelBtn.setDisable(false);
            email.setDisable(false);
            phoneNo.setDisable(false);
            DOB.setDisable(true);
            active.setDisable(false);
            custID.setDisable(true);
            custName.setDisable(true);
        } else if (status == 4){
            submitBtn.setText(" Delete Customer ");
            submitBtn.setDisable(false);
            cancelBtn.setText(" Cancel / Reset ");
            cancelBtn.setDisable(false);
            active.setDisable(true);
            email.setDisable(true);
            phoneNo.setDisable(true);
            DOB.setDisable(true);
            custID.setDisable(true);
            custName.setDisable(true);
        }else {
            cancelBtn.setDisable(true);
            submitBtn.setDisable(true);
            submitBtn.setText(" Submit ");
            cancelBtn.setText(" Cancel");
        }
    }
}
