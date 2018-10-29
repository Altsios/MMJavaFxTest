package MathMethods.Model;

public class Linear extends Trend{

    public Linear(float[] xcoord,float k,float b){
        super(xcoord);

        for (int i = 0; i < N; i++)
            y[i] = x[i]*k+b;
    }
}
