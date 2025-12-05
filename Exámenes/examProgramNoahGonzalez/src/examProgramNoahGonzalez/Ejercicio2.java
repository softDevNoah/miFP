package examProgramNoahGonzalez;

import java.util.Scanner;

public class Ejercicio2 {

	private static Scanner teclado = new Scanner(System.in); 
	private static String entrada;
	
	public static void main(String[] args) {
	
		boolean	esCorrecto;
		int		opcionElegida = -1;
		
		do {
			esCorrecto = true;
			
			imprimirMenu();
			opcionElegida = solicitaNumOpcionMenu();
			
			if (opcionElegida != -1)
				System.out.printf("Has seleccionado la opción %d\n\n", opcionElegida);
			else
				esCorrecto = false;
			
		} while (!esCorrecto);
		
		teclado.close();
	}

	private static void imprimirMenu() {
		System.out.println("\nMenu de opciones:");
		System.out.println("1 - Operacioines Aritméticas");
		System.out.println("2 - Decimales");
		System.out.println("3 - Guardar Productos");
		System.out.println("4 - Calcula Precio\n");
		System.out.print("Elige una opción: ");
	}

	private static int solicitaNumOpcionMenu() {
		
		int	num = -1;
		
		entrada = teclado.nextLine().trim();
		
		if (entrada.isEmpty() || entrada.length() > 1 || !checkNum(entrada))
			return (num);	
		
		num = Integer.parseInt(entrada);
		
		if (num < 1 || num > 4)
			return (-1);
		
		return (num);
	}
	
	private static boolean checkNum(String entrada) {
		
		boolean esCorrecto = true;
		char	c = ' ';
		
		for (int i = 0; i < entrada.length(); i++) {
			
			c = entrada.charAt(i);
			
			if (!Character.isDigit(c)){
				esCorrecto = false;
			}
		}
		
		return (esCorrecto);
	}
}
