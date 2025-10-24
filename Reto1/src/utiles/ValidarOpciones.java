package utiles;

import vista.MostrarMensajeDeError;

public class ValidarOpciones {

	public static boolean checkOpcion(String entrada) {
		
		boolean existe = true;
		if (entrada.isEmpty()) {
			MostrarMensajeDeError.entradaVacia();
			existe = false;
		}
		return (existe);
	}
}
