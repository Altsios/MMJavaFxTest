package MathMethods.Model;
import java.util.Random;

public final class Rand extends Trend {

    public Rand(float[] xcoord,float S){
        super(xcoord);
        Random rnd = new Random(System.currentTimeMillis());

        for (int i = 0; i < N; i++)
            y[i] = rnd.nextFloat();

        float[] minmax=min_max();

        for (int i = 0; i < N; i++)
            y[i]=((y[i]-minmax[1])/(minmax[0]-minmax[1])-0.5f)*2*S;

    }

    public Rand(float[] xcoord){
        this(xcoord,1);
    }


}
