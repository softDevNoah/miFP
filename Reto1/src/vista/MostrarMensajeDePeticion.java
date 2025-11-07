package vista;

import controlador.*;
import main.*;

/**
 * Visualización por pantalla de mensajes de petición de diversos datos y menús de opciones.
 */
public class MostrarMensajeDePeticion {

	/**
	 * Muestra el título del menú, las opciones recogidas por parámetro y la petición de selección de una de éstas.
	 * Siempre que la selección sea incorrecta, imprime el mensaje de error y repite el proceso.
	 * Si recibe null como segundo parámetro, las opciones serán de Sí o No.
	 * 
	 * @param titulo - String que contiene el titulo del menu.
	 * @param opciones - array de Strings con las diversas opciones o null en caso de no haberlas.
	 * @param peticion - mensaje pidiendo una de las opciones mostradas del menu. 
	 * @return indice de la opcion seleccionada del menu (por eso se resta 1 al resultado).
	 */
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
			
			entrada = Main.teclado.nextLine().trim();
			
			if (ValidarTipoDeEntrada.estaDentroDeLimites(entrada) && ValidarTipoDeEntrada.checkSoloNumeroPositivoEntero(entrada)) {
				
				opcionSeleccionada = Integer.parseInt(entrada);
				
				if ((opcionSeleccionada < 1) || (opcionSeleccionada > opciones.length)) {
					MostrarMensajeDeError.mostrarError(8);
					esCorrecto = false;
				}
			}
			else 
				esCorrecto = false;
			
			
		} while (!esCorrecto);
		
		System.out.println("\n-----------------------------------------------------------------------\n");
		
		return (opcionSeleccionada - 1);
	}
	
	/**
	 * Muestra mensaje pidiendo el nombre de usuario o contraseña, segun la opcion que se elija.
	 * @param opcion - indice que representa si se muestra la peticion del usuario o la contraseña.
	 */
	public static void msgIntroduzcaDatoSesion(int opcion) {
		
		String datos[] = { "el nombre de usuario", "la contraseña"};
		
		System.out.printf("*\n\t·····> Introduzca %s, por favor: ", datos[opcion]);
		
	}
	
	/**
	 * Muestra las categorias de producto y la petición de ingresar una de ellas.
	 * @param categorias - Array de Strings que contiene las categorías.
	 */
	public static void msgAsigneCategoria(String categorias[]) {
		System.out.print("\t·····> Asigne una categoría al producto, por favor. ");
		System.out.printf("Categorías posibles: %s, %s, %s, %s: ", categorias[0], categorias[1], categorias[2], categorias[3]);
	}
	
	/**
	 * Muestra un mensaje pidiendo asignar un nombre, precio o id único a un producto.
	 * @param opcion - indice que indica cual es el atributo del producto que se debe imprimir en el mansaje.
	 */
	public static void msgAsigneDato(int opcion) {
		String datos[] = {"nombre", "precio", "ID único"};
		
		System.out.printf("\t·····> Asigne un %s al producto, por favor: ", datos[opcion -1]);
	}
	
}
