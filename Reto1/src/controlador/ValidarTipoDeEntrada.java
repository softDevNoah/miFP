package controlador;

import vista.*;

/**
 * Clase que gestiona la verificación de la entrada de datos por teclado según la necesidad.
 * Tiene métodos para revisar si solo son letras, o es alfanumérico, un nº decimal o entero, etc.
 */
public class ValidarTipoDeEntrada {
	
	/**
	 * Valida que la entrada no esté vacía y no exceda el límite de caracteres,
	 * comprueba que el String tenga al menos 1 carácter y como máximo 8 (límite impuesto).
	 * 
	 * @param entrada - String a validar (entrada del usuario)
	 * @return true si la entrada tiene entre 1 y 8 caracteres, false en caso contrario
	 */
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
	
	/**
	 * Valida que la entrada contenga únicamente letras,
	 * permite espacios en blanco y tabulaciones, pero no números ni símbolos.
	 * 
	 * @param entrada - String a validar
	 * @return true si solo contiene letras (y espacios o tabulaciones), false en caso contrario
	 */
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
	
	/**
	 * Valida que la entrada sea alfanumérica (letras y números, y espacios o tabulaciones).
	 * @param entrada - String a validar introducida por el usuario.
	 * @return true si solo contiene letras, números y espacios o tabulaciones, false en caso contrario
	 */
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
	
	/**
	 * Valida que la entrada sea un número entero positivo.
	 * @param entrada - String a validar
	 * @return true si solo contiene dígitos, false en caso contrario
	 */
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
	
	/**
	 * Permite dígitos y un único punto decimal como separador.
	 * 
	 * @param entrada - String a validar
	 * @return true si es un número decimal válido, false en caso contrario
	 */
	public static boolean checkSoloNumeroDecimal(String entrada) {
		
		boolean esCorrecto = true;
		boolean	hayNums = false;
		int		numPuntos = 0;

		for (int i = 0; i < entrada.length(); i++) {
			
			if (Character.isDigit(entrada.charAt(i)))
				hayNums = true;
			
			else if (entrada.charAt(i) == '.') {
				
				numPuntos++;
				
				if (numPuntos > 1) {
					esCorrecto = false;
					MostrarMensajeDeError.mostrarError(5);
					return (esCorrecto);
				}
			}
			else {
				esCorrecto = false;
				MostrarMensajeDeError.mostrarError(5);
				return (esCorrecto);
			}		
		}
		
		if (!hayNums) {
			MostrarMensajeDeError.mostrarError(5);
			return (hayNums);
		}
		return (esCorrecto);
	}
}
