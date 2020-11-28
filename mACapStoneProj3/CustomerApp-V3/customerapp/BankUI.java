/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customerapp;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author chand
 */
public class BankUI extends Application {

   @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new StackPane());

        FXMLLoader loader = new FXMLLoader(getClass().getResource("rootView.fxml"));
        scene.setRoot(loader.load());
        RootPaneController controller = loader.getController();
        controller.init();

        primaryStage.setScene(scene);
        primaryStage.setTitle(" Customer App ");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
