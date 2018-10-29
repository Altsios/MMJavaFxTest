package MathMethods.Controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RandContr extends ParamCntr {

    @FXML
    private TextField starttxt;

    @FXML
    private TextField endtxt;

    @FXML
    private TextField steptxt;

    @FXML
    private TextField scaletxt;


    @FXML
    private void pressNext(ActionEvent event) {

        try {
            inpvals[0] = Float.parseFloat(starttxt.getText());
            inpvals[1] = Float.parseFloat(endtxt.getText());
            inpvals[2] = Float.parseFloat(steptxt.getText());
            inpvals[3] = Float.parseFloat(scaletxt.getText());
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.close();
        }
        catch (Exception e)
        {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Ошибка!");
            alert.setHeaderText(null);
            alert.setContentText("Проверьте введенное значение!");
            alert.showAndWait();
        }

    }

}
