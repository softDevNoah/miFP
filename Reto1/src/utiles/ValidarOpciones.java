package utiles;

import vista.MostrarMensajeDeError;

public class ValidarOpciones {

	public static boolean checkOpcion(String entrada) {
		
		boolean esCorrecto = true;
		
		if (entrada.isEmpty()) {
			MostrarMensajeDeError.entradaVacia();
			esCorrecto = false;
		}
		else if (entrada.equals("1")  && entrada.equals("2")  && entrada.equals("3")  && entrada.equals("4")) {
			MostrarMensajeDeError.categoriaIncorrecta();
			esCorrecto = false;
		}
		return (esCorrecto);
	}
}
