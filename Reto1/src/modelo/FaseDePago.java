package modelo;

import controlador.*;
import main.*;

public class FaseDePago {

	public static void pagar(double precioTotal) {
		
		double dineroIntroducido = 0;
		double faltante;

		while (dineroIntroducido < precioTotal) {
			
			System.out.println("Introduzca dinero, por favor:");
			
			double cantidad = pedirNumeroDouble();
			
			dineroIntroducido += cantidad;

			if (dineroIntroducido < precioTotal) {
				faltante = precioTotal - dineroIntroducido;
				System.out.printf("Falta por introducir: %.2f€", faltante);
			}
		}
		
		double cambio = dineroIntroducido - precioTotal;
		
		if (cambio > 0) {
			System.out.println("Cambio a devolver: " + String.format("%.2f", cambio) + "€");
			Calculadora.desglosarCambio(cambio);
		}
		System.out.println("Gracias por su compra.");
	
	}
	
	

	public static double pedirNumeroDouble() {
		boolean esCorrecto = false;
		String entrada;
		double numero = 0;
	
		do {
			entrada = Main.teclado.nextLine();
	
			if (ValidarTipoDeEntrada.checkSoloNumeroDecimal(entrada)) {
				numero = Double.parseDouble(entrada);
				esCorrecto = true;
			} else {
				System.out.printf("error\n");
			}
	
		} while (!esCorrecto);
	
		return numero;
	}
	
	
	
	public static double pedirSaldo(int precioTotal) {
		double saldo = 0;
		double tempo = 0;
	
		do {
			saldo = tempo - saldo;
			saldo = pedirNumeroDouble();
			if (saldo < precioTotal) {
				System.out.println("Saldo insuficiente, introduzca más dinero por favor.");
			}
	
		} while (saldo < precioTotal);
	
		return saldo;
	}
		
	
}
