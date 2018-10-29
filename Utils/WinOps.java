package MathMethods.Utils;

import MathMethods.Controllers.Charts.FourChtsCon;
import MathMethods.Controllers.Charts.OneChtCon;
import MathMethods.Controllers.Charts.ThrChtsCon;
import MathMethods.Controllers.Charts.TwoChtsCon;
import MathMethods.Model.Trend;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class WinOps {

    public FXMLLoader LOADER(String path) {
        FXMLLoader loader;

        loader = new FXMLLoader(
                getClass().getResource(
                        path
                )
        );

        return loader;
    }

    protected void OpenWin(String title, ActionEvent event, int minWidth, int minHeight, Parent root) {

        Stage stage = new Stage();
        stage.setTitle(title);
        stage.setMinHeight(minHeight);
        stage.setMinWidth(minWidth);
        stage.setResizable(false);
        stage.setScene(new Scene(root));
        stage.initModality(Modality.WINDOW_MODAL);
        //Указываем родительское окно, элемент Node как базовый для всех компонентов
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.showAndWait();
    }

    protected void OpenOneWIn(ActionEvent event, String title, Trend func) throws IOException {

        FXMLLoader loader = LOADER("../fxml/Charts/OneChart.fxml");
        Parent root = loader.load();
        OneChtCon cont = loader.getController();
        cont.setInfo(new String[]{title}, new Trend[]{func});

        OpenWin("График", event, 750, 550, root);
    }

    protected void OpenTwoWIn(ActionEvent event, String[] titles, Trend[] funcs) throws IOException {

        FXMLLoader loader = LOADER("../fxml/Charts/TwoCharts.fxml");
        Parent root = loader.load();
        TwoChtsCon cont = loader.getController();
        cont.setInfo(titles, funcs);
        OpenWin("График", event, 1000, 700, root);

    }

    void OpenTreeWIn(ActionEvent event,String [] titles,Trend [] funcs) throws IOException {

        FXMLLoader loader = LOADER("../fxml/Charts/ThreeCharts.fxml");
        Parent root = loader.load();
        ThrChtsCon cont = loader.getController();
        cont.setInfo(titles, funcs);

        OpenWin("График", event, 1000, 700, root);
    }

    protected void OpenFourWIn(ActionEvent event, String[] titles, Trend[] funcs) throws IOException {

        FXMLLoader loader = LOADER("../fxml/Charts/FourCharts.fxml");
        Parent root = loader.load();
        FourChtsCon cont = loader.getController();
        cont.setInfo(titles, funcs);

        OpenWin("График", event, 1100, 700, root);
    }

    protected void warning() {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText("Ничего не выбрано!");
        alert.showAndWait();
    }
}
