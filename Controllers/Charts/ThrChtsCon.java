package MathMethods.Controllers.Charts;
import MathMethods.Controllers.Charts.TwoChtsCon;
import MathMethods.Model.Trend;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class ThrChtsCon extends TwoChtsCon {

    @FXML
    protected NumberAxis axxCh3;

    @FXML
    protected NumberAxis axyCh3;

    @FXML
    protected LineChart<Number, Number> ch3;

    public void setInfo(String[] titles, Trend[] funcs){

        setCh(funcs[0],titles[0],ch1,axxCh1,axyCh1,"-fx-stroke: #1E90FF;");
        setCh(funcs[1],titles[1],ch2,axxCh2,axyCh2,"-fx-stroke: #7B68EE");
        setCh(funcs[2],titles[2],ch3,axxCh3,axyCh3,"-fx-stroke: #7B68EE");
    }

}

