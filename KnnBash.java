package examples.KnnBash;
import jade.core.Agent;
import jade.core.behaviours.*;

public class KnnBash extends Agent  {

	public void setup()
	{

		Object[] args =getArguments();
		if (args != null && args.length > 0) {
		double [][] x= {
		// 0 = M
		// 1 = L
		{158, 58, 0, 0},
		{158, 59, 0, 0},
		{158, 63, 0, 0},
		{160, 59, 0, 0},
		{160, 60, 0, 0},
		{163, 60, 0, 0},
		{163, 61, 0, 0},
		{160, 64, 1, 0},
		{163, 64, 1, 0},
		{165, 61, 1, 0},
		{165, 62, 1, 0},
		{165, 65, 1, 0},
		{168, 62, 1, 0},
		{168, 63, 1, 0},
		{168, 66, 1, 0},
		{170, 63, 1, 0},
		{170, 64, 1, 0},
		{170, 68, 1, 0}
		};

		double n = x.length;
		double Resultado = 0;
		for(int i = 0; i < x.length; i++){
			Resultado += x[i][0];
		}
		double Resultado2 = 0;
		for (int i = 0; i < x.length; i++) {
			Resultado2 += x[i][1];
		}

		//Parametros similares, usando a Monica 161, 61
		String primero = (String) args[0];
        String segundo = (String) args[1];
        String tercero = (String) args[2];
		
        System.out.println("Entrada 1: " + primero);
        System.out.println("Entrada 2: " + segundo);
        System.out.println("K: " + tercero);
        System.out.println("========================================== ");

        double valor1 = Double.parseDouble(primero);
        double valor2 = Double.parseDouble(segundo);
        double valor3 = Double.parseDouble(tercero);
		
		for (int i = 0;i<x.length ;i++ ) {
		double Valor2 = Math.pow(valor1 - x[i][0],2) + Math.pow(valor2 - x[i][1],2);
		double Valor = Math.sqrt(Valor2);
		x[i][3] = Valor;
		}

		int K = 1;
		int banderaM = 0, banderaL = 0;
		String Tamano;
		for (int i = 0;i<x.length;i++) {
			double aux;
			double aux2;
			aux  = valor1 - x[i][0];
			aux2 = valor2 - x[i][1];
			if (aux < 0) {
				aux = (-1 * aux);
			};
			if (aux2 < 0) {
				aux2 = (-1 * aux2);
			};
			if (aux <= 2 && aux2 <= 3) {
				if(K <= valor3){
					if (x[i][2] == 0) {
						Tamano = "M"; 
						System.out.println ("Lugar "+ K + ": " + x[i][0] + " : " + x[i][1] + " : " + Tamano + " : " + x[i][3]);
						banderaM = banderaM + 1;
					}
					else if(x[i][2] != 0){
						Tamano = "L";
						System.out.println ("Lugar "+ K + ": " + x[i][0] + " : " + x[i][1] + " : " + Tamano + " : " + x[i][3]);
						banderaL = banderaL + 1;
					}
		  		K = K+1;
		  		}	
			}
		}
		System.out.println("");
		int comp=0;
			comp = banderaM * 100 / 5;
			System.out.println("Compatibilidad de talla M = " + comp);
			comp = banderaL * 100 / 5;
			System.out.println("Compatibilidad de talla L = " + comp);
			System.out.println("");
		if (banderaM > banderaL) {
			System.out.println("Preferencia a elegir: M");
		}
		else if(banderaM < banderaL){
			System.out.println("Preferencia a elegir: L");
		}
		}
		doDelete();
	}
}