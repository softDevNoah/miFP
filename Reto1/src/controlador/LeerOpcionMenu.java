package controlador;

import utiles.*;
import main.Main;

public class LeerOpcionMenu {

	public static int checkOpcionMenu() {
				
		boolean opcionValida = false;
		int		opcionMenu = -1;
		
		String entrada;
		
		do {
			entrada = Main.teclado.nextLine();
			if (ValidarOpciones.checkOpcion(entrada)) {
				opcionMenu = Integer.parseInt(entrada);
				opcionValida = true;
			}
		}while (!opcionValida);

		return (opcionMenu);
	}
}
