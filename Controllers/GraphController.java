package MathMethods.Controllers;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TextArea;


import java.net.URL;
import java.util.ResourceBundle;

public class GraphController implements Initializable {

    @FXML
    private LineChart<String, Number> lcht;

    @FXML
    private CategoryAxis x;

    @FXML
    private NumberAxis y;

    @FXML
    private TextArea txtar;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        XYChart.Series<String,Number> series=new XYChart.Series<String,Number>();
        series.getData().add(new XYChart.Data<String, Number>("Jan",200));
        series.getData().add(new XYChart.Data<String, Number>("Jul",100));
        series.getData().add(new XYChart.Data<String, Number>("Aug",400));
        lcht.getData().add(series);
    }

    public void myFunc(String text){
        txtar.setText(text);
    }
}
