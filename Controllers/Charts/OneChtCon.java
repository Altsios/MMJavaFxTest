package MathMethods.Controllers.Charts;
import MathMethods.Controllers.Charts.ParentGrphControl;
import MathMethods.Model.Trend;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;

public class OneChtCon extends ParentGrphControl {

    @FXML
    protected NumberAxis axxCh1;

    @FXML
    protected NumberAxis axyCh1;

    @FXML
    protected LineChart<Number, Number> ch1;

    public void setInfo(String[] titles, Trend[] funcs){

        setCh(funcs[0],titles[0],ch1,axxCh1,axyCh1,null);
    }

}

