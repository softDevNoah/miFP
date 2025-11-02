package modelo;

import controlador.*;
import main.*;
import vista.*;

public class Pagar {
	
	private static double[] arrEfectivo = { 0.01, 0.02, 0.05, 0.1, 0.2, 0.5, 1, 2, 5, 10, 20, 50, 100, 200};
	public static double[][] arrMonedasContadas = new double[0][2];
		
	public static void pasarelaDePago(double precioTotal) {
		
		double	dineroIntroducido = 0.0;
		double	faltante = precioTotal;
		String	entrada;
		boolean esCorrecto = false;
		double	cambio = 0.0;
		double	saldoAcumulado = 0.0;
		
		while (dineroIntroducido < precioTotal) {
			do {	
				System.out.printf("\t------>>>>>> Importe pendiente: %.2f€.\n\n", faltante);
				System.out.print("\t·····> Introduzca dinero, por favor: ");
				
				entrada = Main.teclado.nextLine();

				if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroDecimal(entrada)) {
					dineroIntroducido = Double.parseDouble(entrada);
					if (dineroIntroducido <= 250) {
						saldoAcumulado += dineroIntroducido;
						esCorrecto = true;
						}
					else
						MostrarMensajeDeError.mostrarError(12);
					}
				System.out.println();
			} while (!esCorrecto);
			
			if (saldoAcumulado < precioTotal) {
				faltante = precioTotal - saldoAcumulado;
			}
			
		}
		
		cambio = saldoAcumulado - precioTotal;
		
		if (cambio > 0) {
			System.out.printf("\t·Su cambio es: %.2f€\n\n", cambio);
			Pagar.desglosarCambio(cambio);
		}

		System.out.println("\n\n\t------>>>>>> Gracias por su compra <<<<<<------");
	}		

	
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
		arrMonedasContadas = expandirArrayDouble(arrMonedasContadas, arrEfectivoYConteo);
		
		return Math.round(cambio * 100.0) / 100.0;
	}

	public static void desglosarCambio(double cambio) {
		int [] billetes= {200, 100, 50, 10, 5, 2, 1};
		int [] monedas= {50, 20, 10, 5, 2, 1};
		
		int euros=(int) cambio;
		int cent= (int) Math.round((cambio-euros)*100);
		
		System.out.println("\t\t·Desglose del cambio: ");
		
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
	
	public static double[][] expandirArrayDouble(double[][] arrayAntiguo, double[][] arrDatosNuevos) {
		int numFilasAntiguo = arrayAntiguo.length;
		int numColAntiguo = (numFilasAntiguo > 0) ? arrayAntiguo[0].length : 0;
		int numFilasDatosNuevos = arrDatosNuevos.length;
		int numColDatosNuevos = arrDatosNuevos[0].length;
		double[][] arrayExpandido;

		if (numFilasAntiguo == 0) {
			arrayExpandido = new double[numFilasDatosNuevos][numColDatosNuevos];

			for (int i = 0; i < numFilasDatosNuevos; i++) {
				for (int j = 0; j < numColDatosNuevos; j++) {
					arrayExpandido[i][j] = arrDatosNuevos[i][j];
				}
			}
		} else {
			arrayExpandido = new double[numFilasAntiguo + numFilasDatosNuevos][numColAntiguo];

			for (int i = 0; i < numFilasAntiguo; i++) {
				for (int j = 0; j < numColAntiguo; j++) {
					arrayExpandido[i][j] = arrayAntiguo[i][j];
				}
			}

			for (int i = 0; i < numFilasDatosNuevos; i++) {
				for (int j = 0; j < numColDatosNuevos; j++) {
					arrayExpandido[numFilasAntiguo + i][j] = arrDatosNuevos[i][j];
				}
			}

		}

		return arrayExpandido;
	}
	
}
