package calc;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author chand
 */
public class Calculator extends Application{

    public static void main(String[] args) {
        launch();
    }
    @FXML
    private TextField outputTF;
    
    @Override
    public void start(Stage stage) throws Exception {
        
        stage.setTitle(" Fx Calculator");
    
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Calculator.fxml"));
        Parent root = loader.load();
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
