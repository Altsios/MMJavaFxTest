package MathMethods.Controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LinCon extends ParamCntr {

    @FXML
    private TextField starttxt;

    @FXML
    private TextField endtxt;

    @FXML
    private TextField steptxt;

    @FXML
    private TextField ktxt;

    @FXML
    private TextField btxt;


    @FXML
    void pressbtn(ActionEvent event) {


        inpvals[0] = Float.parseFloat(starttxt.getText());
        inpvals[1] = Float.parseFloat(endtxt.getText());
        inpvals[2] = Float.parseFloat(steptxt.getText());
        inpvals[3] = Float.parseFloat(ktxt.getText());
        inpvals[4] = Float.parseFloat(btxt.getText());

        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.close();
    }
}
