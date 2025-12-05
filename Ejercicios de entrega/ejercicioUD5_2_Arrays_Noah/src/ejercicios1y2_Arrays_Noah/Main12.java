package ejercicios1y2_Arrays_Noah;

import java.util.Scanner;

/**
 * Esta clase contiene el flujo del programa que ejecuta a demanda los ejercicios 1 y 2 de la entrega 1/3 de arrays. 
 */
public class Main12 {

	public static Scanner	teclado = new Scanner(System.in);
	public static String	entrada;
	public static int		num;
	
	/**
	 * Este método ofrece en bucle tres opciones y ejecuta según se lee por teclado lo que el usuario selecciona:
	 * Ejecutar ejercicio 1, Ejecutar ejercicio 2 o Salir y cerrar el programa.
	 * @param args
	 */
	public static void main(String[] args) {

		String	menu[] = {"Ejecutar ejercicio 1", "Ejecutar ejercicio 2", "Salir del programa"};
		
		
		System.out.println();
		
		do {
			num = MetodAux.menuOpciones("Operaciones disponibles", menu, "Seleccione la operación que desea realizar");
			
			switch (num) {
				case 0:
					MetodAux.pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 1...\n");
					EjecutarEjercicio1.ejercicio1();
					MetodAux.pintarLinea("~", 71);
					break;
				case 1:
					MetodAux.pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 2...\n");
					EjecutarEjercicio2.ejercicio2();
					MetodAux.pintarLinea("~", 71);
					break;
			}
					
		} while(num != 2);
		
		MetodAux.pintarLinea("~", 71);
		System.out.println("\t\t- Saliendo del programa...");
		
		teclado.close();
	}

	
	
}
