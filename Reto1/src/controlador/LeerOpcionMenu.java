package controlador;

import java.util.Scanner;

import utiles.ValidarOpciones;

public class LeerOpcionMenu {

	public static int checkOpcionMenu() {
		Scanner teclado = new Scanner(System.in);
		String	entrada = "VACIO";
		
		boolean opcionValida = false;
		int		opcionMenu = -1;
		
		do {
			entrada = teclado.nextLine();
			if (ValidarOpciones.checkOpcion(entrada)) {
				opcionMenu = Integer.parseInt(entrada);
				opcionValida = true;
			}
		}while (!opcionValida);
		
		teclado.close();
		return (opcionMenu);
	}
}
