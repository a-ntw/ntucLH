
package txhistory;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * 1. need to add FX-11 into project properties 
 * 2. VBM Option > --module-path
 * /Users/antw/javafx/javafx-sdk-11.0.2/lib --add-modules
 * javafx.controls,javafx.fxml,javafx.media
 *
 * @author antw
 */
public class FxTHist extends Application {

    public static void main(String[] args) throws Exception {
//        printH();
        launch();
        //System.exit(0); // never put this
    }

    public static void launchFtHist(int accid) {
        System.out.println("launchFtHist(int accid) " + accid);
                launch();
    }
    // default
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle(" FX TRANSACTION REPORT ");

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FxTHist.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
/*
was
-Djava.util.logging.config.file=/Users/antw/ntuc/cohortProj/CoreBanking/log_v3.properties --module-path /Users/antw/javafx/javafx-sdk-11.0.2/lib --add-modules javafx.controls,javafx.fxml,javafx.media

 */
/*
 //Mac
export  PATH_TO_FX=c:\javafx-sdk-11.0.2\lib
javac --module-path ${PATH_TO_FX} --add-modules javafx.controls HelloFX.java
java --module-path ${PATH_TO_FX} --add-modules javafx.controls HelloFX

// windows
From Chandra to Everyone: (9:14 AM)
 set PATH_TO_FX=c:\javafx-sdk-110.2\lib

javac --module-path %PATH_TO_FX% --add-modules javafx.controls HelloFX.java

java --module-path %PATH_TO_FX% --add-modules javafx.controls HelloFX 


*/