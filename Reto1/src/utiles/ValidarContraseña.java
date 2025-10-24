package utiles;

import modelo.*;
import vista.*;

public class ValidarContraseña {

	public static boolean checkContraseña(String entrada, Usuario administradores[]) {
		
		boolean existe = true;
		if (entrada.isEmpty()) {
			MostrarMensajeDeError.entradaVacia();
			existe = false;
		}
		return (existe);
	}
	
}
