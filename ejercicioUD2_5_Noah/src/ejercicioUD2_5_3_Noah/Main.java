package ejercicioUD2_5_3_Noah;

import java.util.Scanner;

/*Entrega 3 de 4 (5 contando con los ejercicios extra) de los ejercicios del Tema 2.
 * En este paquete se desarrollan los ejercicios del 8 al 12*/

public class Main {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static String	numEjercicio;
	private static int		num;
	
	public static void main(String[] args) {
		
		int opt;
		
		System.out.println("Escribe un nº del 8 al 12 (o 0 para salir).");

		numEjercicio = teclado.nextLine();
		opt = Integer.parseInt(numEjercicio);
		
		while (opt != 0) {
			switch (opt) {
				case 8:
					ejercicio8();
					break;
				case 9:
					ejercicio9();
					break;
				case 10:
					ejercicio10();
					break;
				case 11:
					ejercicio11();
					break;
				case 12:
					ejercicio12();
					break;
			}
			if (opt != 0) {
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("Escribe un nº del 8 al 12 (o 0 para salir).");
				numEjercicio = teclado.nextLine();
				opt = Integer.parseInt(numEjercicio);
			}
		}
	}

	private static void ejercicio8() {
		/*8. Realizar un programa que implemente cuatro operaciones básicas de una calculadora: suma, resta, producto y división.
		 * Mostrar en pantalla el siguiente menú:

		 	*****************

			Calculadora

		 	*****************
			Introduce en número 1:
			Introduce el número 2:
			Introduce la opción deseada:
			1. Suma
			2. Resta
			3. Producto
			4. División
			5. Salir
			Introduce la opción deseada:
			El programa mostrará la operación y su resultado: Ejemplo 3+4=7 */
		
	}
	
	private static void ejercicio9() {
		/*9. Mostrar la tabla de multiplicar del número 5. Mostrar sólo los 10 primeros valores.*/
		
	}
	
	private static void ejercicio10() {
		/*10. Hacer la tabla de multiplicar un número pedido por teclado (while, do while, for).*/
		
	}
	
	private static void ejercicio11() {
		/*11. Desarrollar un programa que permita cargar n números enteros y luego nos informe
		 * cuántos valores fueron pares y cuántos impares. Solicitar antes el número de enteros a tratar.*/
		
	}
	
	private static void ejercicio12() {
		/*12. Mostrar la tabla de multiplicar (mostrar sólo los 10 primeros valores.) de los 10 primeros números.*/
		
	}
}
