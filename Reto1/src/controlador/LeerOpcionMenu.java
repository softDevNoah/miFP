package controlador;

import main.Main;
import utiles.ValidarTipoDeEntrada;

public class LeerOpcionMenu {

	public static int lecturaOpcionMenu() {
				
		boolean opcionValida = false;
		int		opcionMenu = -1;
		
		String entrada;
		
		do {
			entrada = Main.teclado.nextLine();
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				opcionMenu = Integer.parseInt(entrada);
				opcionValida = true;
			}
		}while (!opcionValida);
		
		System.out.println("*  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * *");
		
		return (opcionMenu);
	}
}
