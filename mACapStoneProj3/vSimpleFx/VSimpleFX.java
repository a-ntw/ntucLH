/**
 * Project Properties
 * --module-path /Users/antw/javafx/javafx-sdk-11.0.2/lib --add-modules javafx.controls
 *
 * Libraries > Compile & Run >add JavaFx-11
 *
 */
package vsimplefx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VSimpleFX extends Application {

    public static void main(String[] args) {
        launch();
    }

    // default
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle(" My V Simple FX ");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("newToFx.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
