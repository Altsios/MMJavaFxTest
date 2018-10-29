package MathMethods.Model;

public class Harmonic extends Trend {

    public Harmonic(float[] xcoord,float A,float f, float t){
        super(xcoord);

        for(int i=0; i<N; i++){
            y[i]=A*(float)(Math.sin(2*Math.PI*f*t*x[i]));
        }

    }
}
