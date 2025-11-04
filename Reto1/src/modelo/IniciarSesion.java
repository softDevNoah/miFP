package modelo;

import controlador.ValidarUsuarioYContraseña;
import main.Main;
import vista.MsgPeticion;
import vista.MostrarMensajeInformativo;

public class IniciarSesion {

	public static boolean intentoDeInicio(Usuario administradores[], String usuarioIniciado) {
		
		boolean	sesionIniciada = false;
		
		if (recogerUsuarioYContraseña(administradores, usuarioIniciado))
				sesionIniciada = true;
		
		return (sesionIniciada);
	}
	
	private static boolean recogerUsuarioYContraseña(Usuario administradores[], String usuarioIniciado) {
		
		boolean	esCorrecto = false;
		String	entrada;
		int		numUsuario = 0;
		
		do {
			MsgPeticion.msgIntroduzcaDatoSesion(1);
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarUsuarioYContraseña.checkUsuario(entrada, administradores))
				esCorrecto = true;

		}while (!esCorrecto);
		
		if (esCorrecto) {
			numUsuario = ValidarUsuarioYContraseña.indiceUsuario(entrada, administradores);

		MsgPeticion.msgIntroduzcaDatoSesion(2);
		entrada = Main.teclado.nextLine();
		
		esCorrecto = false;
		
		if (ValidarUsuarioYContraseña.checkContraseña(entrada, administradores, numUsuario))
			esCorrecto = true;

		}
		if (esCorrecto) {
			MostrarMensajeInformativo.msgEstadoSesionCorrecto(administradores[numUsuario].nombre, 1);
			usuarioIniciado = administradores[numUsuario].nombre;
		}
		return (esCorrecto);
	}
}
