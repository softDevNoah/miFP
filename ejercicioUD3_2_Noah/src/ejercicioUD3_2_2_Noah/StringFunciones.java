package ejercicioUD3_2_2_Noah;

import java.util.Scanner;

public class StringFunciones {

	private static	Scanner	teclado = new Scanner(System.in);
	private static	String	entrada;
	
	public static void main(String[] args) {
		
		int		opt;
		String	cadena;
		int		num;
		
		do {
			System.out.println("******************************************");
			System.out.println("Seleccione la opción que desee realizar:");
			System.out.println("\t1 - Pintar una línea.\n\t\t- Se creará una línea con el caracter que elijas y tan larga como indiques.");
			System.out.println("\t2 - Convertir letra a minúscula.\n\t\t- Se mostrará en minúsculas la letra que introduzcas.");
			System.out.println("\t3 - Convertir letra a mayúscula.\n\t\t- Se mostrará en mayúsculas la letra que introduzcas.");
			System.out.println("\t4 - Convertir frase a minúscula.\n\t\t- Se mostrará en minúsculas la frase que introduzcas.");
			System.out.println("\t5 - Convertir frase a mayúscula.\n\t\t- Se mostrará en mayúsculas la frase que introduzcas.");
			System.out.println("\t6 - Salir del programa.");
			
			opt = checkNum();
			switch (opt) {
			
				case 1:
					System.out.println("1.- Pintar línea:");
					cadena = checkCadena(1);
					num = checkNum();
					if (num > 0)
						pintar_linea(cadena.charAt(0), num);
					else
						System.out.println("Error: no se pudo pintar porque el número era 0 o menos de 0.");
					break;
				case 2:
					System.out.println("2.- Convertir letra a minúscula.");
					cadena = checkCadena(1);
					System.out.println("Ahora el caracter es:\n\t" + pasar_minuscula(cadena));
					break;
				case 3:
					System.out.println("3.- Convertir letra a mayúscula.");
					cadena = checkCadena(1);
					System.out.println("Ahora el caracter es:\n\t" + pasar_mayuscula(cadena));
					break;
				case 4:
					System.out.println("4.- Convertir frase a minúscula.");
					cadena = checkCadena(2);
					System.out.println("Ahora el texto es:\n\t" + pasar_minuscula(cadena));
					break;
				case 5:
					System.out.println("5.- Convertir frase a mayúscula.");
					cadena = checkCadena(2);
					System.out.println("Ahora el texto es:\n\t" + pasar_mayuscula(cadena));
					break;
			}
			
		} while (opt != 6);
		System.out.println("Se ha cerrado el programa satisfactoriamente.");
		teclado.close();
	}


		/**
		 * Método que recibe una letra y un número entero, e imprime en pantalla dicha letra tantas veces como indique el número.
		 * @param c		Letra
		 * @param num	Número de veces a pintar
		 */
		private static void pintar_linea(char c, int num) {
			
			for (int i = 0; i < num; i++) {
				System.out.print(c);
			}
			System.out.println();
		}
		
		/**
		 * Método que recibe una cadena, la pasa a minúsculas, y la devuelve.
		 * @param entrada		Cadena original
		 * @return resultado	Cadena en minúsculas
		 */
		private static String pasar_minuscula(String entrada) {
			
			String resultado = entrada.toLowerCase();
			return (resultado);
			
		}
		
		/**
		 * Método que recibe una cadena, la pasa a mayúsculas, y la devuelve.
		 * @param entrada		Cadena original
		 * @return resultado	Cadena en mayúsculas
		 */
		private static String pasar_mayuscula(String entrada) {
			
			String resultado = entrada.toUpperCase();
			return (resultado);
		}
		
		//método auxiliar
		/**
		 * Este método te pide un número entero por teclado y revisa que efectivamente son solamente dígitos.
		 * En caso de no serlo, sigue pidiendo un número.
		 * Cuando es válido, lo transforma en int y lo devuelve.
		 * @return num1	Número entero verificado
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
		 * Método que recibe un entero. Éste indica si se debe pedir por teclado una letra (tipo == 1) o un texto (tipo == 2). 
		 * Solamente devuelve la cadena si es válida y contiene solo una letra o solo texto. Cuando es un texto, es válido que no sean únicamente letras,
		 * por tanto no se revisa con .isAlphabetic().
		 * @param tipo		Número que indica qué condición se aplicará.
		 * @return entrada	Cadena de texto ya validada.
		 */
		private static String checkCadena(int tipo) {
			boolean	validInput;

			if (tipo == 1) {
				do {
					validInput = true;
					System.out.println("________________________");
					System.out.print("Introduzca un solo caracter: ");
					entrada = teclado.nextLine();
					if (entrada.length() != 1) 
						validInput = false;
					if (entrada.length() == 1 && !Character.isAlphabetic(entrada.charAt(0)))
						validInput = false;
					
				} while (!validInput);
			}
			else if (tipo == 2) {
				System.out.println("________________________");
				System.out.print("Introduzca un texto: ");
				entrada = teclado.nextLine();
			}
			return (entrada);
		}
		
}
