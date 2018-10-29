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

import MathMethods.Model.Trend;

public class ThrChtsCon{

    @FXML
    private LineChart<Number, Number> ch1;

    @FXML
    private NumberAxis axxCh1;

    @FXML
    private NumberAxis axyCh1;

    @FXML
    private LineChart<Number, Number> ch2;

    @FXML
    private NumberAxis axxCh2;

    @FXML
    private NumberAxis axyCh2;

    @FXML
    private LineChart<Number, Number> ch3;

    @FXML
    private NumberAxis axxCh3;

    @FXML
    private NumberAxis axyCh3;
 /*   @Override
    public void initialize(URL location, ResourceBundle resources) {




        XYChart.Series<Integer,Integer> series=new XYChart.Series<Integer,Integer>();
        series.getData().add(new XYChart.Data<Integer, Integer>(1,200));
        series.getData().add(new XYChart.Data<Integer, Integer>(2,100));
        series.getData().add(new XYChart.Data<Integer, Integer>(3,400));
        ch1.getData().add(series);
    }*/

    public void setInfo(String [] titles, Trend[] funcs){

        ch1.setTitle(titles[0]);
        ch2.setTitle(titles[1]);
        ch3.setTitle(titles[2]);
    }
}

