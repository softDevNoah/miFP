package ejercicioUD2_6_1_Noah;

import java.util.Scanner;

/*Entrega 1 de 2 de los ejercicios del Tema 2 (Ejercicios String).
 * En este paquete se desarrollan los ejercicios del 1 al 6*/

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
				case 1:
					ejercicio1();
					break;
				case 2:
					ejercicio2();
					break;
				case 3:
					ejercicio3();
					break;
				case 4:
					ejercicio4();
					break;
				case 5:
					ejercicio5();
					break;
				case 6:
					ejercicio6();
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

	private static void ejercicio1() {
		
		
	}
	
	private static void ejercicio2() {
		
		
	}
	
	private static void ejercicio3() {
		
		
	}
	
	private static void ejercicio4() {
		
		
	}
	
	private static void ejercicio5() {
		
		
	}
	
	private static void ejercicio6() {
		
		
	}
	
}
