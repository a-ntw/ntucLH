package calc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
 

public class CalculatorController implements Initializable {
 
    Double temp = 0.0, sum = 0.0;
    Double lmsVal = 0.0;
    boolean isOperatorPressed;
    String operatorPressed = "";
          
    @FXML
    private TextField result;
    @FXML
    private TextArea mStore;
    @FXML
    private TextArea tStore;
    @FXML
    private Button tc;
    @FXML
    private Button mp;
    @FXML
    private Button mm;
    @FXML
    private Button mc;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        result.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                if (!newValue.matches("\\d*([\\.]\\d*)?")) {
                    result.setText(oldValue);
                }
            }
        });
    }    
    
    @FXML
    private void onNumberClick(ActionEvent event) {
        if(event.getSource() instanceof Button) {
            Button btn = (Button)event.getSource();                                               
            if(isOperatorPressed) {
                result.setText(btn.getText().trim());                
            } else {
                result.setText(result.getText().trim() + btn.getText().trim());
            }
            isOperatorPressed = false;
        }
    }
    
    @FXML
    private void onOperatorClick(ActionEvent event) {
       String tVal = tStore.getText();
        if(event.getSource() instanceof Button) {
            Button btn = (Button)event.getSource();            
            if (!result.getText().isEmpty()) {
                temp = Double.valueOf(result.getText());
                
                if (btn.getText().equals("%")) {
                    temp = sum * temp / 100;   
                }
                switch (operatorPressed) {                    
                    case "/":
                        tVal += sum + " / " + temp + " = " + (sum /= temp);
                        break;
                    case "X":
                        tVal += sum + " * " + temp + " = " + (sum *= temp);
                        break;
                    case "+":
                        tVal += sum + " + " + temp + " = " + (sum += temp);
                        break;
                    case "-":
                        tVal += sum + " - " + temp + " = " + (sum -= temp);
                        break;
                    default:
                        sum = temp;      
                }
            }                     
            tStore.setText(tVal + "\n");
            tc.setDisable(false);
            if (btn.getText().equals("=") || btn.getText().equals("%")) {
                result.setText(String.valueOf(sum));                
                operatorPressed = "";
            } else {
                result.setText("");                
                operatorPressed = btn.getText().trim();
            }
            isOperatorPressed = true;
        }
    }        
    
    @FXML
    private void onDELClick(ActionEvent event) {
        if(result.getText().length() > 0) {
            result.setText(result.getText(0, result.getText().length() - 1));
        }        
    }
    
    @FXML
    private void onCEClick(ActionEvent event) {
        result.setText("");
        temp = 0.0;
        sum = 0.0;
        isOperatorPressed = false;
        operatorPressed = "";
    }

    @FXML
    private void tClear(ActionEvent event) {
        tStore.setText("");
        tc.setDisable(true);
    }

    @FXML
    private void mStore(ActionEvent event) {
        mp.setDisable(false);
        mm.setDisable(false);
        mc.setDisable(false);
        lmsVal = Double.parseDouble(result.getText());
        mStore.setText(result.getText() + "\n" + mStore.getText());
    }

    @FXML
    private void mPlus(ActionEvent event) {
        result.setText((Double.valueOf(result.getText()) + lmsVal) +"");
    }

    @FXML
    private void mMinus(ActionEvent event) {
        result.setText((Double.valueOf(result.getText()) - lmsVal) +"");
    }

    @FXML
    private void mClear(ActionEvent event) {
        mStore.setText("");
        mp.setDisable(true);
        mm.setDisable(true);
        mc.setDisable(true);
    }
}