package MathMethods.Controllers;

import MathMethods.Model.Trend;
import MathMethods.Utils.WinOps;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TasksCntr extends WinOps implements Initializable {

    private Trend tr;
    private String Name;

    @FXML
    private ListView<String> lst;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        lst.setItems(FXCollections.observableArrayList(
                "График", "Автокорреляция", "Преобразование Фурье"));

    }

    void setRef(Trend source, String name){
        tr=source;
        Name=name;
    }


    @FXML
    private void ActNxt(ActionEvent event) {

        int idx = lst.getSelectionModel().getSelectedIndex();


        switch (idx) {

            case 0:
                try {
                    OpenOneWIn(event, Name, tr);
                } catch (IOException e) {
                System.out.println(e.toString());
                }
                break;

            case 1:
                try {
                    OpenTwoWIn(event, new String[]{Name,"Автокорреляция"}, new Trend[] {tr,tr.Rxx()});
                } catch (IOException e) {
                    System.out.println(e.toString());
                }
                break;

            case 2:
                System.out.println(2);
                break;

            case 3:
                System.out.println(3);
                break;

            default:
                warning();
                break;

        }

    }


}
