package controlador;

import main.Main;
import modelo.*;
import utiles.*;
import vista.*;

public class RecogerUsuarioYContraseña {

	public static boolean recogerUsuarioYContraseña(Usuario administradores[]) {
		
		boolean	esValido = false;
		String	entrada;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaUsuario();
			entrada = Main.teclado.nextLine();
			if (ValidarUsuario.checkUsuario(entrada, administradores)) {
				esValido = true;
			}
		}while (!esValido);
		
		esValido = false;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaContraseña();
			entrada = Main.teclado.nextLine();
			if (ValidarContraseña.checkContraseña(entrada, administradores)) {
				esValido = true;
			}
		}while (!esValido);
		
		return (esValido);
	}
}
