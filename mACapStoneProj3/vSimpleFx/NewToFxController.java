/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vsimplefx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class NewToFxController implements Initializable {

    boolean isOperatorPressed;

    @FXML
    private Button mySimpleButton;
    @FXML
    private TextField textfield1;
    @FXML
    private TextArea textArea1;

    /**
     * Initializes the cont @FXML private TextField textfield1;
     *
     * @FXML private TextArea textArea1; roller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    private int count = 0;

    @FXML
    private void thisSimpleMethod(ActionEvent event) {
        mySimpleButton.setText("Clicks " + count++);

        String r = textfield1.getText() + "\n" + mySimpleButton.getText();
        textArea1.setText(r);

        textfield1.setText("0");
    }

    @FXML
    private void onThisClick(ActionEvent event) {
        if (event.getSource() instanceof Button) {
            Button btn = (Button) event.getSource();
            if (isOperatorPressed) {
                textfield1.setText(btn.getText().trim());
            } else {
                textfield1.setText(textfield1.getText().trim() + btn.getText().trim());
            }
            isOperatorPressed = false;
        }
    }

}
