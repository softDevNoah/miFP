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
		
		int		opt = checkNum();
		String	c;
		int		num;
		String	frase;
		
		do {
			System.out.println("******************************************");
			System.out.println("Seleccione la opción que desee realizar:");
			System.out.println("\t1 - Pintar una línea.\n\t\t- Se creará una línea con el caracter que elijas y tan larga como indiques.");
			System.out.println("\t2 - Convertir letra a minúscula.\n\t\t- Se mostrará en minúsculas la letra que introduzcas.");
			System.out.println("\t3 - Convertir letra a mayúscula.\n\t\t- Se mostrará en mayúsculas la letra que introduzcas.");
			System.out.println("\t4 - Convertir frase a minúscula.\n\t\t- Se mostrará en minúsculas la frase que introduzcas.");
			System.out.println("\t5 - Convertir frase a mayúscula.\n\t\t- Se mostrará en mayúsculas la frase que introduzcas.");
			System.out.println("\t6 - Salir del programa.");
			
			switch (opt) {
			
				case 1:
					c = checkChar();
					num = checkNum();
					pintar_linea(c.charAt(0), num);
					break;
				case 2:
					c = checkChar();
					pasar_minuscula(c);
					break;
				case 3:
					c = checkChar();
					pasar_mayuscula(c);
					break;
				case 4:
					entrada = teclado.nextLine();
					pasar_minuscula(entrada);
					break;
				case 5:
					entrada = teclado.nextLine();
					pasar_mayuscula(entrada);
					break;
			}
			
		} while (opt != 0);
		
		
	}

		private static void pintar_linea(char c, int num) {
			
		}
		
		private static void pasar_minuscula(String entrada) {
			
		}
		
		private static void pasar_mayuscula(String entrada) {
			
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
		
		//método auxiliar
		/**
		 * Este método te pide un número entero por teclado y revisa que efectivamente son solamente dígitos.
		 * En caso de no serlo, sigue pidiendo un número.
		 * Cuando ya es válido, lo transforma en int y lo devuelve.
		 * @return int num1
		 */
		private static int checkChar() {
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
