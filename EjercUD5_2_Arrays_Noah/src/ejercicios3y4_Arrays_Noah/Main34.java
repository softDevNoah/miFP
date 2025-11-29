package ejercicios3y4_Arrays_Noah;

import java.util.Scanner;

import ejercicios1y2_Arrays_Noah.MetodAux;

public class Main34 {

	public static Scanner	teclado = new Scanner(System.in);
	public static String		entrada;
	public static int		num;
	
	public static void main(String[] args) {

		String	menu[] = {"Ejecutar ejercicio 3", "Ejecutar ejercicio 4", "Salir del programa"};
		
		
		System.out.println();
		
		do {
			num = MetodAux.menuOpciones("Operaciones disponibles", menu, "Seleccione la operación que desea realizar");
			
			switch (num) {
				case 0:
					MetodAux.pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 3...\n");
					EjecutarEjercicio34.ejercicio3();
					MetodAux.pintarLinea("~", 71);
					break;
				case 1:
					MetodAux.pintarLinea("~", 71);
					System.out.println("\n\tEjecutando Ejercicio 4...\n");
					EjecutarEjercicio34.ejercicio4();
					MetodAux.pintarLinea("~", 71);
					break;
			}
					
		} while(num != 2);
		MetodAux.pintarLinea("~", 71);
		System.out.println("\t\t- Saliendo del programa...");
		
		teclado.close();
	}

}
