package utiles;

import vista.*;

public class ValidarTipoDeEntrada {
	
	public static boolean estaDentroDeLimites(String entrada) {
		boolean esCorrecto = true;
		
		if (entrada.isEmpty()) {
			MostrarMensajeDeError.entradaVacia();
			esCorrecto = false;
		}
		else if (entrada.length() > 8) {
			esCorrecto =false;
			MostrarMensajeDeError.entradaDemasiadoExtensa();
		}
		return (esCorrecto);
	}
	
	public static boolean checkSoloTexto(String entrada) {
		
		boolean esCorrecto = true;

		for (int i = 0; i < entrada.length(); i++) {
			if (!Character.isLetter(entrada.charAt(i)) && entrada.charAt(i) != ' ' && entrada.charAt(i) != '\t') 
				esCorrecto = false;
		}
		if (!esCorrecto)
			MostrarMensajeDeError.noEsSoloTexto();
		return (esCorrecto);
	}
	
	public static boolean checkSoloNumeroEntero(String entrada) {
		boolean esCorrecto = true;

		for (int i = 0; i < entrada.length(); i++) {
			if (i == 0 && (entrada.charAt(i) == '-' || entrada.charAt(i) == '+'))
					i++;
			if (!Character.isDigit(entrada.charAt(i)))
				esCorrecto = false;
		}

		if (!esCorrecto)
			MostrarMensajeDeError.noEsSoloUnNumero();
		return (esCorrecto);
	}
	
	public static boolean checkSoloAlfanumerico(String entrada) {
		boolean esCorrecto = true;

		for (int i = 0; i < entrada.length(); i++) {
			if (!Character.isLetterOrDigit(entrada.charAt(i)) && entrada.charAt(i) != ' ' && entrada.charAt(i) != '\t') 
				esCorrecto = false;
		}
		if (!esCorrecto)
			MostrarMensajeDeError.noEsSoloAlfanumerico();
		return (esCorrecto);
	}
	
	public static boolean checkSoloSiONo(String entrada) {
	
		boolean esCorrecto = true;

		if (entrada.length() == 2) {
			if (entrada.charAt(0) != 'S' && entrada.charAt(0) != 's') {
				if (entrada.charAt(1) != 'i' && entrada.charAt(1) != 'I'
						&& entrada.charAt(1) != 'í' && entrada.charAt(1) != 'Í')
					esCorrecto = false;
			}
			else if  (entrada.charAt(0) != 'N' && entrada.charAt(0) != 'n')
				if (entrada.charAt(1) != 'O' && entrada.charAt(1) != 'o') {
					esCorrecto = false;
			}
		}
		else
			esCorrecto = false;
		
		if (!esCorrecto)
			MostrarMensajeDeError.noEsSoloSiONo();

		return (esCorrecto);
	}
		
	public static boolean checkSoloNumeroPositivoEntero(String entrada) {
		boolean esCorrecto = true;

		for (int i = 0; i < entrada.length(); i++) {
			if (!Character.isDigit(entrada.charAt(i)))
				esCorrecto = false;
		}
		if (!esCorrecto)
			MostrarMensajeDeError.noEsSoloUnNumero();
		return (esCorrecto);
	}
}
