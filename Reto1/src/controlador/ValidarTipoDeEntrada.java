package controlador;

import vista.*;

public class ValidarTipoDeEntrada {
	
	public static boolean estaDentroDeLimites(String entrada) {
		boolean esCorrecto = true;
		
		if (entrada.isEmpty()) {
			MostrarMensajeDeError.mostrarError(0);
			esCorrecto = false;
		}
		else if (entrada.length() > 8) {
			esCorrecto =false;
			MostrarMensajeDeError.mostrarError(1);
		}
		return (esCorrecto);
	}
	
	public static boolean checkSoloLetras(String entrada) {
		
		boolean esCorrecto = true;

		for (int i = 0; i < entrada.length(); i++) {
			if (!Character.isLetter(entrada.charAt(i)) && entrada.charAt(i) != ' ' && entrada.charAt(i) != '\t') 
				esCorrecto = false;
		}
		if (!esCorrecto)
			MostrarMensajeDeError.mostrarError(2);
		return (esCorrecto);
	}
		
	public static boolean checkSoloAlfanumerico(String entrada) {
		boolean esCorrecto = true;

		for (int i = 0; i < entrada.length(); i++) {
			if (!Character.isLetterOrDigit(entrada.charAt(i)) && entrada.charAt(i) != ' ' && entrada.charAt(i) != '\t') 
				esCorrecto = false;
		}
		if (!esCorrecto)
			MostrarMensajeDeError.mostrarError(4);
		return (esCorrecto);
	}
	
	public static boolean checkSoloNumeroPositivoEntero(String entrada) {
		boolean esCorrecto = true;

		for (int i = 0; i < entrada.length(); i++) {
			if (!Character.isDigit(entrada.charAt(i)))
				esCorrecto = false;
		}
		if (!esCorrecto)
			MostrarMensajeDeError.mostrarError(3);
		return (esCorrecto);
	}
	
	public static boolean checkSoloNumeroDecimal(String entrada) {
		
		boolean esCorrecto = true;
		int		numPuntos = 0;

		for (int i = 0; i < entrada.length(); i++) {
			if (!Character.isDigit(entrada.charAt(i)) && entrada.charAt(i) != '.')
				esCorrecto = false;
			if (entrada.charAt(i) == '.')
				numPuntos++;
		}
		if (!esCorrecto || numPuntos > 1)
			MostrarMensajeDeError.mostrarError(5);
		return (esCorrecto);
	}
}
