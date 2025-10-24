package modelo;

import controlador.*;

public class IniciarSesion {

	public static boolean intentoDeInicio(Usuario administradores[]) {
		
		boolean	sesionIniciada = false;
		
		if (RecogerUsuarioYContraseña.recogerUsuario(administradores) && RecogerUsuarioYContraseña.recogerContraseña(administradores))
				sesionIniciada = true;
		
		return (sesionIniciada);
	}
}
