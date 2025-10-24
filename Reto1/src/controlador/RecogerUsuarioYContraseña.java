package controlador;

import java.util.Scanner;

import modelo.*;
import utiles.*;
import vista.*;

public class RecogerUsuarioYContraseña {

	public static boolean recogerUsuarioYContraseña(Usuario administradores[]) {
		
		boolean	esValido = false;
		Scanner	teclado = new Scanner(System.in);
		String	entrada;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaUsuario();
			entrada = teclado.nextLine();
			if (ValidarUsuario.checkUsuario(entrada, administradores)) {
				esValido = true;
			}
		}while (!esValido);
		
		esValido = false;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaContraseña();
			entrada = teclado.nextLine();
			if (ValidarContraseña.checkContraseña(entrada, administradores)) {
				esValido = true;
			}
		}while (!esValido);
		
		teclado.close();
		
		return (esValido);
	}
}
