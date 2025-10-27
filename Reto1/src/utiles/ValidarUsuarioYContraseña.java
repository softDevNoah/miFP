package utiles;

import modelo.*;
import vista.*;

public class ValidarUsuarioYContraseña {

	public static boolean checkUsuario(String entrada, Usuario administradores[]) {
		
		boolean existe = false;
		
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloAlfanumerico(entrada)) {
			for (int i = 0; i < 4; i++) {
				if (entrada.equals(administradores[i].nombre))
					existe = true;
			}
		}
		if (!existe)
			MostrarMensajeDeError.usuarioNoExiste(entrada);
		return (existe);
	}
	
	public static int indiceUsuario(String entrada, Usuario administradores[]) {
	
		int	indiceUsuario = -1;
		
		for (int i = 0; i < 4; i++) {
			if (entrada.equals(administradores[i].nombre))
				indiceUsuario = i;
		}
		
		return (indiceUsuario);
	}
	
	public static boolean checkContraseña(String entrada, Usuario administradores[], int indiceUsuario) {
		
		boolean existe = true;
		if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloAlfanumerico(entrada)) {
			if (!entrada.equals(administradores[indiceUsuario].contraseña)) {
				existe = false;
				MostrarMensajeDeError.contraseñaIncorrecta();
			}
		}
		return (existe);
	}
}
