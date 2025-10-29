package modelo;

import controlador.ValidarUsuarioYContraseña;
import main.Main;
import vista.MostrarMensajeDePeticion;
import vista.MostrarMensajeOperacionCorrecta;

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
		int		numUsuario = 0;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaUsuario();
			entrada = Main.teclado.nextLine();
			if (ValidarUsuarioYContraseña.checkUsuario(entrada, administradores)) {
				esCorrecto = true;
				//numUsuario = buscarCoincidenciaEnUsuarios
			}
		}while (!esCorrecto);
		
		if (esCorrecto) {
			numUsuario = ValidarUsuarioYContraseña.indiceUsuario(entrada, administradores);
			
			esCorrecto = false;
			
			do {
				MostrarMensajeDePeticion.msgIntroduzcaContraseña();
				entrada = Main.teclado.nextLine();
				if (ValidarUsuarioYContraseña.checkContraseña(entrada, administradores, numUsuario))
					esCorrecto = true;
			} while (!esCorrecto);
		}
		if (esCorrecto)
			MostrarMensajeOperacionCorrecta.msgInicioSesionCorrecto(administradores[numUsuario].nombre);
		return (esCorrecto);
	}
}
