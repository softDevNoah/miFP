package ejercicios5y6y7_Arrays_Noah;

import java.util.Scanner;

import ejercicios1y2_Arrays_Noah.MetodAux;

public class Main567 {

	public static Scanner	teclado = new Scanner(System.in);
	public static String		entrada;
	public static int		num;
	
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
