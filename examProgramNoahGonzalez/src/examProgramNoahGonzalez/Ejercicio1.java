package examProgramNoahGonzalez;

import java.util.Scanner;

public class Ejercicio1 {

	private static Scanner teclado = new Scanner(System.in); 
	private static String entrada;
	
	public static void main(String[] args) {
	
		int		opcionElegida = -1;
		
		imprimirMenu();
		
		opcionElegida = solicitaNumOpcionMenu();
		
		System.out.printf("Has seleccionado la opción %d", opcionElegida);
		
		teclado.close();
	}

	private static void imprimirMenu() {
		
		System.out.println("Menu de opciones:");
		System.out.println("1 - Operaciones Aritméticas"); //la palabra "Operaciones" tiene una errata en el enunciado y lo puse corregido.
		System.out.println("2 - Decimales");
		System.out.println("3 - Guardar Productos");
		System.out.println("4 - Calcula Precio\n");
		System.out.print("Elige una opción: ");
	}

	private static int solicitaNumOpcionMenu() {
		int	num = -1;
		
		entrada = teclado.nextLine().trim();
		
		num = Integer.parseInt(entrada);
		
		return (num);
	}
}
