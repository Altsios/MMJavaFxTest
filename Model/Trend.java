package MathMethods.Model;

public class Trend {

    protected float [] x;
    protected float [] y;
    protected int N;

    public Trend(float[] xcoord){

        N=xcoord.length;
        x=new float[N];
        y=new float[N];
        System.arraycopy (xcoord,0,x,0,N);
    }

    public Trend(float[] xcoord, float [] ycoord){

        this(xcoord);
        System.arraycopy (ycoord,0,y,0,N);
    }

    //region Getters
    public float [] getX() {
        return x;
    }

    public float [] getY() {
        return y;
    }

    public int getN(){return N;}
    //endregion
    //region Char-cs
    public final float [] min_max(){

        float []arr={y[0],y[0]};

        for (int i=1;i<y.length;i++){
            if(y[i]>arr[0])
            arr[0]=y[i];


            if(y[i]<arr[1])
                arr[1]=y[i];
        }

        //0-й эл-т -макс, 1-й - мин

        return arr;
    }

    public final float _xf(){

        float sum=0f;

        for (float el:y) {
            sum+=el;
        }
        return sum/N;
    }

    public final float _D(){
        float sum=0f;
        float _x=_xf();

        for (float el:y) {
            sum+=(float) Math.pow(el-_x,2);
        }
        return sum/N;
    }

    public final Trend Rxx(){

        float [] RxxL=new float[N];
        float _x=_xf();


        float sum;
        float denom;
        for(int L = 0; L<N; L++){

            sum=0f;
            denom=0f;
            for (int K=0;K<N-L;K++){
                sum+=(y[K]-_x)*(y[K+L]-_x);
            }
            for (int K=0;K<N;K++){
                denom+=(float) Math.pow(y[K]-_x,2);
            }
            RxxL[L]=sum/denom;
        }

        return new Trend(x,RxxL);
    }


    public static Trend Rxy(Trend x,Trend y){

        float [] RxxL=new float[x.N];
        float _x=x._xf();
        float _y=y._xf();

        float sum;
        for(int L = 0; L<x.N; L++){

            sum=0f;
            for (int K=0;K<x.N-L;K++){
                sum+=(x.y[K]-_x)*(y.y[K+L]-_y);
            }
            RxxL[L]=sum/x.N;
        }

        return new Trend(x.x,RxxL);
    }
    //endregion

    float [] Cn(){
        float [] cn=new float[N];
        float [] Rn=new float[N];
        float [] Im=new float[N];

        for(int n=0; n<N;n++)
        {
            for (int k=0; k<N;k++)
            {
                Rn[n]+=y[k]*(float)(Math.cos(2*Math.PI*n*k));
                Im[n]+=y[k]*(float)(Math.sin(2*Math.PI*n*k));
            }
            Rn[n]/=N;
            Im[n]/=N;
            cn[n]=(float)Math.sqrt(Math.pow(Rn[n],2)+Math.pow(Im[n],2));
        }

        return cn;
    }

}
