package examProgramNoahGonzalez;

import java.util.Scanner;

public class Ejercicio3 {

	private static Scanner teclado = new Scanner(System.in); 
	private static String entrada;
	
	public static void main(String[] args) {
	
		int		opcionElegida;
		
		do {
			opcionElegida = seleccionarOperacionMenu();
			
			switch (opcionElegida) {
				case 0:
					msgOperacionSeleccionada(opcionElegida);
					System.out.println("Hasta la próxima.\n+++++++++++++++++++++++++");
					break;
				case 1:
					operacionesAritmeticas(opcionElegida);
					break;
				case 2:
					decimal(opcionElegida);
					break;
				case 3:
					guardar5productos(opcionElegida);
					break;
				case 4:
					calcularPrecio(opcionElegida);
					break;
			}
		} while (opcionElegida != 0);
		teclado.close();
	}

	private static void operacionesAritmeticas(int opcionElegida) {
		msgOperacionSeleccionada(opcionElegida);
	}
	
	private static void decimal(int opcionElegida) {
		msgOperacionSeleccionada(opcionElegida);
	}
	
	private static void guardar5productos(int opcionElegida) {
		msgOperacionSeleccionada(opcionElegida);
	}
	
	private static void calcularPrecio(int opcionElegida) {
		msgOperacionSeleccionada(opcionElegida);
	}
	
	private static void msgOperacionSeleccionada(int opcionElegida) {
		System.out.printf("Ejecutando opción %d\n\n", opcionElegida);
	} 
	
	private static int seleccionarOperacionMenu() {
		
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
		return (opcionElegida);
	}
	
	private static void imprimirMenu() {
		System.out.println("\nMenu de opciones:");
		System.out.println("0 - Salir");
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
		
		if (num < 0 || num > 4)
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
