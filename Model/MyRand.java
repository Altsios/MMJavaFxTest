package MathMethods.Model;


public final class MyRand extends Trend{

    public MyRand(float[] xcoord,float S){
        super(xcoord);

        final float a = System.currentTimeMillis()/ (float)45;
        final float c = System.currentTimeMillis() / (float)21;
        final float m = System.currentTimeMillis() / (float)67;
        float seed = System.currentTimeMillis() / (float)2;

        for(int i=0; i<N; i++){
            seed=(a * seed + c) % m;
            y[i]=seed;
        }

        float[] minmax=min_max();

        for (int i = 0; i < N; i++)
            y[i]=((y[i]-minmax[1])/(minmax[0]-minmax[1])-0.5f)*2*S;
    }

    public MyRand(float[] xcoord){
        this(xcoord,1);
    }
}
