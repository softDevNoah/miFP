package ejercicioUD2_6_2_Noah;

import java.util.Scanner;

/*Entrega 2 de 2 de los ejercicios del Tema 2 (Ejercicios String).
 * En este paquete se desarrollan los ejercicios 7 y 8*/

public class Main {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static String	numEjercicio;
	private static int		num;
	
	public static void main(String[] args) {
		
		int opt;
		
		System.out.println("Escribe un nº del 1 al 5 (o 0 para salir).");
		
		numEjercicio = teclado.nextLine();
		opt = Integer.parseInt(numEjercicio);
		
		while (opt != 0) {
			switch (opt) {
				case 7:
					ejercicio7();
					break;
				case 8:
					ejercicio8();
					break;

			}
			if (opt != 0) {
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("Escribe un nº del 1 al 5 (o 0 para salir).");
				numEjercicio = teclado.nextLine();
				opt = Integer.parseInt(numEjercicio);
			}
		}
		teclado.close();
	}

	private static void ejercicio7() {
		
		
	}
	
	private static void ejercicio8() {
		
		
	}
}
