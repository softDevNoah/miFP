package controlador;

import java.util.Scanner;

import modelo.*;
import utiles.*;
import vista.*;

public class RecogerUsuarioYContraseña {

	public static boolean recogerUsuario(Usuario administradores[]) {
		
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
		
		teclado.close();
		
		return (esValido);
	}
	
	public static boolean recogerContraseña(Usuario administradores[]) {
		boolean	esValida = false;
		Scanner	teclado = new Scanner(System.in);
		String	entrada;
		
		do {
			MostrarMensajeDePeticion.msgIntroduzcaContraseña();
			entrada = teclado.nextLine();
			if (ValidarContraseña.checkContraseña(entrada, administradores)) {
				esValida = true;
			}
		}while (!esValida);
		
		teclado.close();
		
		return (esValida);
	}
}
