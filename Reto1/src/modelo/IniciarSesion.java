package modelo;

import controlador.*;

public class IniciarSesion {

	public static boolean intentoDeInicio(Usuario administradores[]) {
		
		boolean	sesionIniciada = false;
		
		if (RecogerUsuarioYContraseña.recogerUsuarioYContraseña(administradores))
				sesionIniciada = true;
		
		return (sesionIniciada);
	}
}
