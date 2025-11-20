package EjercUD5_2_Arrays_Noah;

import java.util.Scanner;

public class Main {

	public static Scanner	teclado = new Scanner(System.in);
	public static String	entrada;
	public static int		num;
	
	public static void main(String[] args) {

		String	menu[] = {"Ejecutar ejercicio 1", "Ejecutar ejercicio 2", "Ejecutar ejercicio 3", "Ejecutar ejercicio 4", "Ejecutar ejercicio 5",
						"Ejecutar ejercicio 6", "Ejecutar ejercicio 7", "Salir del programa"};
		
		
		System.out.println();
		
		do {
			num = MetodAux.menuOpciones("Operaciones disponibles", menu, "Seleccione la operación que desea realizar");
			
			switch (num) {
				case 0:
					System.out.println("\n-----------------------------------------------------------------------\n");
					System.out.println("\n\tEjecutando Ejercicio 1...\n");
					EjecutarEjercicio.ejercicio1();
					System.out.println("\n-----------------------------------------------------------------------\n");
					break;
				case 1:
					System.out.println("\n-----------------------------------------------------------------------\n");
					System.out.println("\n\tEjecutando Ejercicio 2...\n");
//					EjecutarEjercicio.ejercicio2();
					System.out.println("\n-----------------------------------------------------------------------\n");
					break;
				case 2:
					System.out.println("\n-----------------------------------------------------------------------\n");
					System.out.println("\n\tEjecutando Ejercicio 3...\n");
//					EjecutarEjercicio.ejercicio3();
					System.out.println("\n-----------------------------------------------------------------------\n");
					break;
				case 3:
					System.out.println("\n-----------------------------------------------------------------------\n");
					System.out.println("\n\tEjecutando Ejercicio 4...\n");
//					EjecutarEjercicio.ejercicio4();
					System.out.println("\n-----------------------------------------------------------------------\n");
					break;
				case 4:
					System.out.println("\n-----------------------------------------------------------------------\n");
					System.out.println("\n\tEjecutando Ejercicio 5...\n");
//					EjecutarEjercicio.ejercicio5();
					System.out.println("\n-----------------------------------------------------------------------\n");
					break;
				case 5:
					System.out.println("\n-----------------------------------------------------------------------\n");
					System.out.println("\n\tEjecutando Ejercicio 6...\n");
//					EjecutarEjercicio.ejercicio6();
					System.out.println("\n-----------------------------------------------------------------------\n");
					break;
				case 6:
					System.out.println("\n-----------------------------------------------------------------------\n");
					System.out.println("\n\tEjecutando Ejercicio 7...\n");
//					EjecutarEjercicio.ejercicio7();
					System.out.println("\n-----------------------------------------------------------------------\n");
					break;
			}
					
		} while(num != 7);
		System.out.println("\n-----------------------------------------------------------------------\n");
		System.out.println("\t\t- Saliendo del programa...");
		
		teclado.close();
	}

}
