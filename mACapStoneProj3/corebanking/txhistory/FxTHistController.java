
package txhistory;

import corebanking.CoreBanking;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author antw
 */
public class FxTHistController implements Initializable {
//    public TxHist(LocalDateTime txdate, int txcode, double txamt, String desc) {

    @FXML
    private TableView<TxHist> txtable;
    @FXML
    private TableColumn<TxHist, LocalDateTime> txdate;
    @FXML
    private TableColumn<TxHist, Integer> txcode;
    @FXML
    private TableColumn<TxHist, String> txdesc;
    @FXML
    private TableColumn<TxHist, Double> txamt;
    @FXML
    private Label label1;
    @FXML
    private Button button_exit;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        init();
    }

    public void init() {

        try {
            label1.setText("TRANSACTION HISTORY");

            txtable.setStyle("-fx-alignment: CENTRE-LEFT");
            txdate.setCellValueFactory(new PropertyValueFactory<TxHist, LocalDateTime>("txdate"));
            txcode.setCellValueFactory(new PropertyValueFactory<TxHist, Integer>("txcode"));
            txamt.setCellValueFactory(new PropertyValueFactory<TxHist, Double>("txamt"));
            txdesc.setCellValueFactory(new PropertyValueFactory<TxHist, String>("desc"));

            int accid = TxHist.glovalVarInt;
            List<TxHist> s = new ArrayList<>();
            s = HistDAO.oHistByAccid(accid);
            txtable.setItems((ObservableList<TxHist>) s);

        } catch (Exception e) {
            System.out.println("Exception in CustomerListFXML Controller " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void exit1(ActionEvent event) throws Exception {
        //Thread.sleep(4000);
        //CoreBanking.BankOpe();//  //Return to main
        System.exit(0);
    }
}
