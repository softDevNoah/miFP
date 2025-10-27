package controlador;

import vista.MostrarMensajeDeError;
import main.Main;

public class LeerOpcionMenu {

	public static int lecturaOpcionMenu() {
				
		boolean opcionValida = false;
		int		opcionMenu = -1;
		
		String entrada;
		
		do {
			entrada = Main.teclado.nextLine();
			if (checkOpcion(entrada)) {
				opcionMenu = Integer.parseInt(entrada);
				opcionValida = true;
			}
		}while (!opcionValida);

		return (opcionMenu);
	}
	
	public static boolean checkOpcion(String entrada) {
		
		boolean esCorrecto = true;
		
		if (entrada.isEmpty()) {
			MostrarMensajeDeError.entradaVacia();
			esCorrecto = false;
		}
		else if (entrada.equals("1")  && entrada.equals("2")  && entrada.equals("3")  && entrada.equals("4")) {
			MostrarMensajeDeError.categoriaIncorrecta();
			esCorrecto = false;
		}
		return (esCorrecto);
	}
}
