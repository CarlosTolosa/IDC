package examples.MultipleRegresion;
import jade.core.Agent;
import jade.core.behaviours.*;

public class MultipleRegresion extends Agent    { 
      
    public void setup() 
        { 
           
            Object[] args = getArguments();
            if (args != null &&args.length>0) {
            double [][] x = {{41.9, 29.1, 251.3},
            {43.4, 29.3, 251.3},
            {43.9, 29.5, 248.3},
            {44.5, 29.7, 267.5},
            {47.3, 29.9, 273.0},
            {47.5, 30.3, 276.5},
            {47.9, 30.5, 270.3},
            {50.2, 30.7, 274.9},
            {52.8, 30.8, 285.0},
            {53.2, 30.9, 290.0},
            {56.7, 31.5, 297.0},
            {57.0, 31.7, 302.5},
            {63.5, 31.9, 304.5},
            {65.3, 32.0, 309.3},
            {71.1, 32.1, 321.7},
            {77.0, 32.5, 330.7},
            {77.8, 32.9, 349.0}
            };

            double n = x.length;
            double SumatoryX_1 = 0;
            for (int i = 0;i<x.length;i++) {
                SumatoryX_1 += x[i][0];
            };
            double SumatoryX_2 =0;
            for (int i =0;i<x.length;i++) {
                SumatoryX_2 += x[i][1];
            };
            double SumatoryX2_1 =0;
            for (int i=0;i<x.length;i++) {
                SumatoryX2_1 += Math.pow(x[i][0],2);
            };
            double SumatoryX2_2 =0;
            for (int i =0;i<x.length;i++) {
                SumatoryX2_2 += Math.pow(x[i][1],2);
            };
            double SumatoryX1_X2 =0;
            for (int i =0;i<x.length;i++) {
                SumatoryX1_X2 += (x[i][0] * x[i][1]);
            };
            double SumatoryX2_X1 =0;
            for (int i =0;i<x.length;i++) {
                SumatoryX2_X1 += (x[i][1] * x[i][0]);
            };
            double SumatoryY =0;
            for (int i =0;i<x.length;i++) {
                SumatoryY += x[i][2];
            };
            double SumatoryX_1Y =0;
            for (int i =0;i<x.length;i++ ) {
                SumatoryX_1Y += (x[i][0] * x[i][2]);
            };
            double SumatoryX_2Y =0;
            for (int i =0;i<x.length;i++ ) {
                SumatoryX_2Y += (x[i][1] * x[i][2]);
            };
            double Determinante = 0;
            Determinante = (n*SumatoryX2_1*SumatoryX2_2)+(SumatoryX_1*SumatoryX2_X1*SumatoryX_2)+(SumatoryX_2*SumatoryX_1*SumatoryX1_X2)-
                        (SumatoryX_2*SumatoryX2_1*SumatoryX_2)-(n*SumatoryX1_X2*SumatoryX2_X1)-(SumatoryX2_2*SumatoryX_1*SumatoryX_1);
            
            double B0Determinante =(SumatoryY*SumatoryX2_1*SumatoryX2_2)+(SumatoryX_1*SumatoryX2_X1*SumatoryX_2Y)+(SumatoryX_2*SumatoryX_1Y*SumatoryX1_X2)
                                -(SumatoryX_2Y*SumatoryX2_1*SumatoryX_2)-(SumatoryX1_X2*SumatoryX2_X1*SumatoryY)-(SumatoryX2_2*SumatoryX_1Y*SumatoryX_1);
            
            double B1Determinante =(n*SumatoryX_1Y*SumatoryX2_2)+(SumatoryY*SumatoryX2_X1*SumatoryX_2)+(SumatoryX_2*SumatoryX_1*SumatoryX_2Y)-
                                    (SumatoryX_2*SumatoryX_1Y*SumatoryX_2)-(SumatoryX_2Y*SumatoryX2_X1*n)-(SumatoryX2_2*SumatoryX_1* SumatoryY);

            double B2Determinante =(n*SumatoryX2_1*SumatoryX_2Y)+(SumatoryX_1*SumatoryX_1Y*SumatoryX_2)+(SumatoryY*SumatoryX_1*SumatoryX1_X2)-
                                    (SumatoryX_2*SumatoryX2_1*SumatoryY)-(SumatoryX1_X2*SumatoryX_1Y*n)-(SumatoryX_2Y*SumatoryX_1*SumatoryX_1);
                      
            double B0 = B0Determinante / Determinante;
            double B1 = B1Determinante / Determinante;
            double B2 = B2Determinante / Determinante;

            System.out.println("Y'= B0 " + B0 + "B1 " + B1 + " B2 " + B2 + "\n");

            String primero = (String) args[0];
            String segundo = (String) args[1];

            System.out.println("X1: " + primero);
            System.out.println("X2: " + segundo);

            double valor1 = Double.parseDouble(primero);
            double valor2 = Double.parseDouble(segundo);
            double prediccion = B0 + (B1 * valor1) + (B2 * valor2);
            System.out.println("La prediccion de: X1 " + valor1 + " y X2 " + valor2 + " es: \n\n " + prediccion);
        }
         doDelete();
    }
}