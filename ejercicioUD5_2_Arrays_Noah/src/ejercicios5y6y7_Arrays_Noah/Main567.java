package ejercicios5y6y7_Arrays_Noah;

import java.util.Scanner;

/**
 * Esta clase contiene un menú de opciones para seleccionar el ejercicio que se desea ejecutar
 * de la entrega 3/3 de Arrays, que contiene los ejercicios 5, 6 y 7.
 * Tiene  3 variables globales que se irán usando a lo largo del programa y llama a diversos métodos.
 */
public class Main567 {

	public static Scanner	teclado = new Scanner(System.in);
	public static String	entrada;
	public static int		num;
	
	/**
	 * Método que contiene el funcionamiento lógico del programa con un menú que se muestra en bucle.
	 * @param args
	 */
	public static void main(String[] args) {

		String	menu[] = {"Ejecutar ejercicio 5", "Ejecutar ejercicio 6", "Ejecutar ejercicio 7", "Salir del programa"};
		
		System.out.println();
		
		do {
			num = MetodAux.menuOpciones("Operaciones disponibles", menu, "Seleccione la operación que desea realizar");
			
			switch (num) {
				case 0:
					MetodAux.pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 5...\n");
					Ejercicios.ejecutar5();
					MetodAux.pintarLinea("~", 71);
					break;
				case 1:
					MetodAux.pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 6...\n");
					Ejercicios.ejecutar6();
					MetodAux.pintarLinea("~", 71);
					break;
				case 2:
					MetodAux.pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 7...\n");
					Ejercicios.ejecutar7();
					MetodAux.pintarLinea("~", 71);
					break;

			}
					
		} while(num != 3);
		MetodAux.pintarLinea("~", 71);
		System.out.println("\t\t- Saliendo del programa...");
		
		teclado.close();
	}

}
