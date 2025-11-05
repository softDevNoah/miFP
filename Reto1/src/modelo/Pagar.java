package modelo;

import controlador.*;
import main.*;
import vista.*;

public class Pagar {
			
	public static void pasarelaDePago(double precioTotal) {
		
		double	dineroIntroducido = 0.0;
		double	faltante = precioTotal;
		String	entrada;
		boolean esCorrecto;
		double	cambio = 0.0;
		double	saldoAcumulado = 0.0;
		
		while (saldoAcumulado < precioTotal) {
			
			esCorrecto = false;
			
			do {	
				System.out.printf("\t·Saldo introducido: %.2f€\n\n", saldoAcumulado);

				System.out.printf("\t------>>>>>> Importe pendiente: %.2f€.\n\n", faltante);
				System.out.print("\t·····> Introduzca dinero, por favor: ");
				
				entrada = Main.teclado.nextLine().trim();

				if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroDecimal(entrada)) {
					dineroIntroducido = Double.parseDouble(entrada);
					if (saldoAcumulado + dineroIntroducido <= 250) {
						saldoAcumulado += dineroIntroducido;
						esCorrecto = true;
						}
					else
						MostrarMensajeDeError.mostrarError(12);
					}
				System.out.println();
			} while (!esCorrecto);
			
			if (saldoAcumulado < precioTotal) 
				faltante = precioTotal - saldoAcumulado;
		}
		
		cambio = saldoAcumulado - precioTotal;
		
		if (cambio > 0) {
			System.out.printf("\t·Su cambio es: %.2f€\n\n", cambio);
			Pagar.desglosarCambio(cambio);
		}

		System.out.println("\n\n\t------>>>>>> Gracias por su compra <<<<<<------");
	}		

	private static void desglosarCambio(double cambio) {
		int [] billetes= {200, 100, 50, 20, 10, 5, 2, 1};
		int [] monedas= {50, 20, 10, 5, 2, 1};
		
		int euros=(int) cambio;
		int cent= (int) Math.round((cambio-euros)*100);
		
		System.out.println("\t\t·Desglose del cambio: ");
		
		for (int b : billetes) {
			int cantidad = euros / b;
			if( cantidad > 0) {
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
