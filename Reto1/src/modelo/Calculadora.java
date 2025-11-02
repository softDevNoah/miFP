package modelo;

public class Calculadora {
	
	private static double[] arrEfectivo = { 0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100, 200};
	public static double[][] arrMonedasContadas = new double[0][2];
	
	
	public static void desglosarCambioD(double cambio) {
		double valorEfectivo;

		for (int i = arrEfectivo.length - 1; i >= 0; i--) {
			valorEfectivo = arrEfectivo[i];

			if (cambio >= valorEfectivo) {
				cambio = contarMonedas(cambio, valorEfectivo);
			}
		}
	}

	public static double contarMonedas(double cambio, double valorEfectivo) {
		double[][] arrEfectivoYConteo = new double[1][2];
		int conteo = 0;

		conteo = (int) (cambio / valorEfectivo);
		cambio = cambio % valorEfectivo;

		arrEfectivoYConteo[0][0] = valorEfectivo;
		arrEfectivoYConteo[0][1] = conteo;
		arrMonedasContadas = ExpandirArray.expandirArrayDouble(arrMonedasContadas, arrEfectivoYConteo);
		
		return Math.round(cambio * 100.0) / 100.0;
	}

	public static void desglosarCambio(double cambio) {
		int [] billetes= {200, 100, 50, 10, 5, 2, 1};
		int [] monedas= {50, 20, 10, 5, 2, 1};
		
		int euros=(int) cambio;
		int cent= (int) Math.round((cambio-euros)*100);
		
		System.out.println("\t\tDesglose del cambio: ");
		
		for (int b: billetes) {
			int cantidad= euros/b;
			if(cantidad>0) {
				System.out.printf("\t\t\t" + cantidad + " x "+ b + "€\n");
				euros%=b;
			}
		}
		
		for (int m: monedas) {
			int cantidad=cent/m;
			if(cantidad>0) {
				System.out.println("\t\t\t" + cantidad + " x " + m + " céntimos");
				cent%=m;
			}
		}
	
	}
}
