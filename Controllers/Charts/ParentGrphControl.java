package MathMethods.Controllers.Charts;

import MathMethods.Model.Trend;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public abstract class ParentGrphControl {

    protected float maxmin [];
    protected int N=-1;

    public abstract void setInfo(String [] titles, Trend[] funcs);

    protected float [] getCoords(float [] x, float [] y, int N, LineChart<Number, Number> ch)
    {
        XYChart.Series<Number, Number> series=new XYChart.Series<>();
        for(int i=0;i<N;i++)
            series.getData().add(new XYChart.Data<>(x[i],y[i]));

        ch.getData().add(series);

        return new float[]{x[0],x[N-1]};

    }

    protected void setCh(Trend tr, String title, LineChart<Number, Number> ch, NumberAxis axxCh, NumberAxis axyCh,String style)
    {
        ch.setTitle(title);
        if (N==-1)N=tr.getN();
        if(maxmin==null)
            maxmin = getCoords(tr.getX(),tr.getY(),N,ch);
        else getCoords(tr.getX(),tr.getY(),N,ch);



        axxCh.setAutoRanging(false);
        axxCh.setLowerBound(maxmin[0]-1);
        axxCh.setUpperBound(maxmin[1]);
        axxCh.setTickUnit(100);


        ch.setLegendVisible(false);

        if (style!=null){
            Node nodew = ch.lookup(".chart-series-line");
            nodew.setStyle(style);
        }

    }
}
