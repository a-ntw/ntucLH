/*
1. using SceneBuilder app
2. Project Properties > Library > Compile & Run add > JavaFx-11
3. VM Option: --module-path /Users/antw/javafx/javafx-sdk-11.0.2/lib
        --add-modules javafx.controls,javafx.fxml,javafx.media
 */
package fxtableview;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author antw
 */
public class FxTableview extends Application{

    @Override   ///// / default
    public void start(Stage stage) throws Exception {

        stage.setTitle(" My FX TableView with col and label");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Fxml.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
