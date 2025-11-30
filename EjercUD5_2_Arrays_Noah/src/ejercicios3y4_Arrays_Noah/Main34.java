package ejercicios3y4_Arrays_Noah;

import java.util.Scanner;

public class Main34 {

	public static Scanner	teclado = new Scanner(System.in);
	public static String		entrada;
	public static int		num;
	
	public static void main(String[] args) {

		String	menu[] = {"Ejecutar ejercicio 3", "Ejecutar ejercicio 4", "Salir del programa"};
		
		
		System.out.println();
		
		do {
			num = menuOpciones("Operaciones disponibles", menu, "Seleccione la operación que desea realizar");
			
			switch (num) {
				case 0:
					pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 3...\n");
					Ejercicios.ejecutar3();
					pintarLinea("~", 71);
					break;
				case 1:
					pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 4...\n");
					Ejercicios.ejecutar4();
					pintarLinea("~", 71);
					break;
			}
					
		} while(num != 2);
		pintarLinea("~", 71);
		System.out.println("\t\t- Saliendo del programa...");
		
		teclado.close();
	}

	private static void pintarLinea(String c, int num) {
		
		System.out.println();
		for(int i = 0; i < num; i++)
			System.out.printf("%s", c);
		System.out.println();
	
	}
	
	/**
	 * Esta función recibe un String que hará de título de un menú, un array de Strings (o null) que se usará como listado de opciones
	 * de dicho menú, y un String que servirá como petición de entrada de datos por teclado.
	 * Posteriormente, recoge dicha entrada, valida que sea de un tipo válido, revisa que está entre las opciones que se muestran, y lo
	 * devuelve (un número entero que indica el índice o posición de la opción del menú que se ha elegido).
	 * 
	 * @param titulo	- String título del menú de opciones.
	 * @param opciones	- Array de Strings opciones del menú, o null, que indica que será de respuesta sí o no.
	 * @param peticion	- String de petición de entrada de datos.
	 * @return posicion - int de posición de la respuesta elegida dentro del array "opciones".
	 */
	public static int menuOpciones(String titulo, String opciones[], String peticion) {
		
		String	siNo[] = {"Sí", "No"};
		int		opcionSeleccionada = 0;
		boolean	esCorrecto;
		
		if (opciones == null)
			opciones = siNo;
		do {
			esCorrecto = true;
			System.out.printf("\n\n\t------> %s <<<<<<------\n\n", titulo);
			
			for (int i = 0; i < opciones.length; i++) 
				System.out.printf("\t\t%d.- %s.\n", i + 1, opciones[i]);
			
			System.out.printf("\n\t·····> %s: ", peticion);
			
			Main34.entrada = Main34.teclado.nextLine().trim();
			
			if (!Main34.entrada.isEmpty() && checkSoloNumeroPositivoEntero(Main34.entrada)) {
				
				opcionSeleccionada = Integer.parseInt(Main34.entrada);
				
				if ((opcionSeleccionada < 1) || (opcionSeleccionada > opciones.length)) {
					System.out.println("\t-------> Error: opción incorrecta...");
					esCorrecto = false;
				}
			}
			else 
				esCorrecto = false;
			
			
		} while (!esCorrecto);
		
		return (opcionSeleccionada - 1);
	}
	
	public static boolean checkSoloNumeroPositivoEntero(String entrada) {
		boolean esCorrecto = true;

		for (int i = 0; i < entrada.length(); i++) {
			if (i == 0 && entrada.charAt(i) == '+')
				i++;
			if (!Character.isDigit(entrada.charAt(i)))
				esCorrecto = false;
		}
		return (esCorrecto);
	}
}
