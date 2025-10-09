package ejercicioUD3_2_2_Noah;

import java.util.Scanner;

public class StringFunciones {

	private static	Scanner	teclado = new Scanner(System.in);
	private static	String	entrada;
	
	public static void main(String[] args) {
		
		menu();
		teclado.close();
	}

	
	private static void menu() {
		
		int	opt = checkNum();
		do {
			System.out.println("******************************************");
			System.out.println("Seleccione la opción que desee realizar:");
			System.out.println("");
			
		} while (opt != 0);
		
		
	}

	//método auxiliar
		/**
		 * Este método te pide un número entero por teclado y revisa que efectivamente son solamente dígitos.
		 * En caso de no serlo, sigue pidiendo un número.
		 * Cuando ya es válido, lo transforma en int y lo devuelve.
		 * @return int num1
		 */
		private static int checkNum() {
			boolean	validInput;
			int		num;
			do {
				validInput = true;	//es importante resetear en true, para evitar quedar en un posible bucle infinito
				System.out.println("________________________");
				System.out.print("Introduzca un número: ");
				entrada = teclado.nextLine();
				for (int i = 0; i < entrada.length(); i++) {
					if (!Character.isDigit(entrada.charAt(i))) {
						if ((i == 0 && entrada.charAt(i) != '-') || i > 0) {//con este if verifico que sean validos los negativos
							validInput = false;
							break;
						}
						
					}
				}
			} while (!validInput);
			num = Integer.parseInt(entrada);
			return (num);
		}
}
