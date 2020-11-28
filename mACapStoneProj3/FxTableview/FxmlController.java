package fxtableview;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author antw
 */
public class FxmlController implements Initializable {

    @FXML
    private TableView<alist> custTable;
    @FXML
    private Label label1;
    @FXML
    private TableColumn<alist, Integer> cust_id;
    @FXML
    private TableColumn<alist, String> cust_name;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
    }

    public void init() {
        try {
            label1.setText("This is label, label1.");

            custTable.setStyle("-fx-alignment: CENTER-LEFT;");
            cust_id.setCellValueFactory(new PropertyValueFactory<>("custID"));
            cust_name.setCellValueFactory(new PropertyValueFactory<>("custName"));
            custTable.setItems(alist.oRows());
        } catch (Exception e) {
            System.out.println(" Exception in CustomerListFXML Controller " + e.getMessage());
            e.printStackTrace();
        }
    }

}
