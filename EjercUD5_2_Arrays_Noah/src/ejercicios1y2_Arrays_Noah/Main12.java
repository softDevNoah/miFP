package ejercicios1y2_Arrays_Noah;

import java.util.Scanner;

public class Main12 {

	public static Scanner	teclado = new Scanner(System.in);
	public static String	entrada;
	public static int		num;
	
	public static void main(String[] args) {

		String	menu[] = {"Ejecutar ejercicio 1", "Ejecutar ejercicio 2", "Salir del programa"};
		
		
		System.out.println();
		
		do {
			num = MetodAux.menuOpciones("Operaciones disponibles", menu, "Seleccione la operación que desea realizar");
			
			switch (num) {
				case 0:
					MetodAux.pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 1...\n");
					EjecutarEjercicio12.ejercicio1();
					MetodAux.pintarLinea("~", 71);
					break;
				case 1:
					MetodAux.pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 2...\n");
//					EjecutarEjercicio.ejercicio2();
					MetodAux.pintarLinea("~", 71);
					break;
			}
					
		} while(num != 2);
		
		MetodAux.pintarLinea("~", 71);
		System.out.println("\t\t- Saliendo del programa...");
		
		teclado.close();
	}

	
	
}
