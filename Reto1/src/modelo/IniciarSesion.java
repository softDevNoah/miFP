package modelo;

import main.Main;
import utiles.ValidarContraseña;
import utiles.ValidarUsuario;
import vista.MostrarMensajeDePeticion;

public class IniciarSesion {

	public static boolean intentoDeInicio(Usuario administradores[]) {
		
		boolean	sesionIniciada = false;
		
		if (recogerUsuarioYContraseña(administradores))
				sesionIniciada = true;
		
		return (sesionIniciada);
	}
	
	public static boolean recogerUsuarioYContraseña(Usuario administradores[]) {
		
		boolean	esCorrecto = false;
		String	entrada;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaUsuario();
			entrada = Main.teclado.nextLine();
			if (ValidarUsuario.checkUsuario(entrada, administradores)) {
				esCorrecto = true;
			}
		}while (!esCorrecto);
		
		esCorrecto = false;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaContraseña();
			entrada = Main.teclado.nextLine();
			if (ValidarContraseña.checkContraseña(entrada, administradores)) {
				esCorrecto = true;
			}
		} while (!esCorrecto);
		
		return (esCorrecto);
	}
}
