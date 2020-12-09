package examples.SimpleRegresion;
import jade.core.Agent;
import jade.core.behaviours.*;

public class SimpleRegresion extends Agent    { 
      
    public void setup() 
        { 
           
            Object[] args = getArguments();
            String s;
            int n = 0;
            double[] y = {651,762,856,1063,1190,1298,1421,1440,1518};
            double[] x = {23,26,30,34,43,48,52,57,58};
            double b, a, h, B1, B0 =0;
            n=x.length;
            double SXiYi, SX, SY, SX2, SY2, SX_2;
            SXiYi=SX=SY=SX2=SY2=0.0;
            for(int i=0; i<n; i++){
                    SX+=x[i];
                    SY+=y[i];
                    SX2+=x[i]*x[i];
                    SY2+=y[i]*y[i];
                    SXiYi+=x[i]*y[i];
                }
                
                SX_2= SX*SX;
                B1 =(n*SXiYi-SX*SY)/(n*SX2-SX*SX);
                B0 =(SY*SX2-SX*SXiYi)/(n*SX2-SX_2);

            if (args != null) {
                for (int r = 0; r<args.length; r++) {
                    s = (String) args[r];
                    System.out.println("My name is "+getLocalName()+" Empezaremos con Regresion Simple");
                    System.out.println("B1: "+ B1);
                    System.out.println("B0: "+ B0);
                    System.out.println("--------------------------------------------------");
                    System.out.println("Y' = " + B0 +" + "+ B1 + " X");
                    System.out.println("X = "+ s);
                    
                }
                int r = Integer.parseInt( (String) args[0] );
                a = B0 + B1 * r;
                System.out.println("--------------------------------------------------");
                System.out.println("Y' = " +  a);
            }
        }
}