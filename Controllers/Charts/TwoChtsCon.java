package MathMethods.Controllers.Charts;
import MathMethods.Model.Trend;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class TwoChtsCon extends OneChtCon {

    @FXML
    protected NumberAxis axxCh2;

    @FXML
    protected NumberAxis axyCh2;

    @FXML
    protected LineChart<Number, Number> ch2;

    public void setInfo(String[] titles, Trend[] funcs){

        setCh(funcs[0],titles[0],ch1,axxCh1,axyCh1,"-fx-stroke: #1E90FF;");
        setCh(funcs[1],titles[1],ch2,axxCh2,axyCh2,"-fx-stroke: #7B68EE");

    }

}

