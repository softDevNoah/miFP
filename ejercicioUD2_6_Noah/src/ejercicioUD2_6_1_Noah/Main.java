package ejercicioUD2_6_1_Noah;

import java.util.Scanner;

/*Entrega 1 de 2 de los ejercicios del Tema 2 (Ejercicios String).
 * En este paquete se desarrollan los ejercicios del 1 al 6*/

public class Main {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static String	numEjercicio;
	//private static int		num;
	
	public static void main(String[] args) {
		
		int opt;
		
		System.out.println("Escribe un nº del 1 al 6 (o 0 para salir).");
		
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
				System.out.println("Escribe un nº del 1 al 6 (o 0 para salir).");
				numEjercicio = teclado.nextLine();
				opt = Integer.parseInt(numEjercicio);
			}
		}
		teclado.close();
	}

	private static void ejercicio1() {
		
		int		stringLen = 0;
		char	charInIndex;
		
		do {
			System.out.println("Introduzca el texto que quiera: ");
			
			entrada = teclado.nextLine();
			
		} while (entrada == "");
		
		System.out.println("Calculando la longitud del texto introducido...:");
		stringLen = entrada.length();
		System.out.println("\tLa longitud de tu texto es de " + stringLen + " caracteres.");
		
		System.out.println("Buscando el carácter en la posición 7 del texto...:");
		if (stringLen >= 8) {
			charInIndex = entrada.charAt(7);
			System.out.println("\tEl carácter que se encuentra en la posición 7 de tu String es \'" + charInIndex + "\'");
		}
		else
			System.out.println("\tTu texto no es tan largo para ver qué caracter hay en la posición 7.");
		
		System.out.println("Buscando una \'x\' en el texto...:");
		if (entrada.indexOf('x') != -1) {
			System.out.println("\tLa letra \'x\' aparece en la posición " + entrada.indexOf('x') + " de tu texto.");
		}
		else
			System.out.println("\tCarácter no encontrado");
		System.out.println("Cambiando el texto original todo a mayúsculas...:");
		System.out.println(entrada.toUpperCase());
	}
	
	private static void ejercicio2() {
		
		int		contador = 0;
		
		System.out.println("Introduzca el texto que quiera: ");
		entrada = teclado.nextLine();
		
		while (entrada.indexOf('a') != -1) {
			contador++;
			entrada = entrada.substring(entrada.indexOf('a') + 1, entrada.length());
		}
		if (contador > 0)
			System.out.println("Hay " + contador + " letras \'a\' en el texto introducido.");
		else
			System.out.println("No había ninguna \'a\' en el texto introducido.");
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
