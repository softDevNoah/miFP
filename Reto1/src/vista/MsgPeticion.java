package vista;

import controlador.*;
import main.*;

public class MsgPeticion {

	public static int menuOpciones(String titulo, String opciones[], String peticion) {
		
		String	siNo[] = {"Sí", "No"};
		int		opcionSeleccionada = 0;
		boolean	esCorrecto;
		String	entrada;
		
		if (opciones == null)
			opciones = siNo;
		do {
			esCorrecto = true;
			System.out.printf("\n\t------> %s <<<<<<------\n\n", titulo);
			
			for (int i = 0; i < opciones.length; i++) 
				System.out.printf("\t\t%d.- %s.\n", i + 1, opciones[i]);
			
			System.out.printf("\n\t·····> %s: ", peticion);
			
			entrada = Main.teclado.nextLine();
			
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				
				opcionSeleccionada = Integer.parseInt(entrada);
				
				if ((opcionSeleccionada < 1) || (opcionSeleccionada > opciones.length)) {
					MostrarMensajeDeError.opcionIncorrecta();
					esCorrecto = false;
				}
			}
			else 
				esCorrecto = false;
			
			
		} while (!esCorrecto);
		
		System.out.println("\n-----------------------------------------------------------------------\n");
		
		return (opcionSeleccionada - 1);
	}
	
	public static void msgIntroduzcaDatoSesion(int opcion) {
		
		String datos[] = { "el nombre de usuario", "la contraseña"};
		
		System.out.printf("*\n\t·····> Introduzca %s, por favor: ", datos[opcion - 1]);
		
	}
	
	public static void msgAsigneCategoria(String categorias[]) {
		System.out.print("\t·····> Asigne una categoría al producto, por favor. ");
		System.out.printf("Categorías posibles: %s, %s, %s, %s: ", categorias[0], categorias[1], categorias[2], categorias[3]);
	}
	
	public static void msgAsigneDato(int opcion) {
		String datos[] = {"nombre", "precio"};
		
		System.out.printf("\t·····> Asigne un %s al producto, por favor: ", datos[opcion -1]);
	}
	
}
