package ejercicioUD3_2_1_Noah;

import java.util.Scanner;

public class Main {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static int		num1;
	private static int		num2;
	
	public static void main(String[] args) {
		
		int opt;
		do {
			System.out.println("\n_____________________________________________________________\n");
			System.out.println("Selecciona una opción (solo el número):");
			System.out.println("1 - ejercicio 1 - esPar()");
			System.out.println("2 - ejercicio 2 - contar pares de lista de 10 num");
			System.out.println("3 - ejercicio 3 - esMayor()");
			System.out.println("4 - ejercicio 4 - esPrimo()");
			System.out.println("5 - ejercicio 5 - calculadora()");
			System.out.println("0 - Salir de este programa.\n");
		
			entrada = teclado.nextLine();
			opt = Integer.parseInt(entrada);
		
			switch (opt) {
				case 1:
					num1 = checkNum();
					if (esPar(num1))
						System.out.print("El número introducido es par.");
					else
						System.out.print("El número introducido es impar.");
					break;
				case 2:
					conteoDePares();
					break;
				case 3:
					num1 = checkNum();
					num2 = checkNum();
					if (num1 != num2)
						System.out.println("El mayor es " + esMayor(num1, num2));
					else
						System.out.println(num1 + " y " + num2 + " son iguales.");
					break;
				case 4:
					num1 = checkNum();
					if (esPrimo(num1))
						System.out.println("El nº introducido es primo.");
					else
						System.out.println("El nº introducido no es primo.");
					break;
				case 5:
						
					break;
				case 0:
						
					break;
				}

		} while (opt != 0);
		System.out.println("\n_______________________________________________");
		System.out.println("El programa se ha cerrado satisfactoriamente.");
		teclado.close();
	}

	/**
	 * Esta función te pide un número por teclado y revisa que efectivamente son solamente dígitos.
	 * En caso de no serlo, sigue pidiendo un número.
	 * Cuando ya es válido, lo transforma en int y lo devuelve.
	 * @return int num1
	 */
	private static int checkNum() {
		boolean	validInput;
		do {
			validInput = true;	//es importante resetear en true, para evitar quedar en un posible bucle infinito
			System.out.println("________________________");
			System.out.print("Introduzca un número: ");
			entrada = teclado.nextLine();
			for (int i = 0; i < entrada.length(); i++) {
				if (!Character.isDigit(entrada.charAt(i))) {
					validInput = false;
					break;
				}
			}
		} while (!validInput);
		num1 = Integer.parseInt(entrada);
		return (num1);
	}
	
	private static void calculadora() {
		
	}
	
	/**
	 * Esta función genera diez números aleatorios entre el 1 y el 100 y cuenta cuántos de ellos son pares.
	 * Muestra el resultado por pantalla.
	 */
	private static void conteoDePares() {
		int	[]randomNum = new int[10];
		int	pares = 0;
		for (int i = 0; i < 10; i++) {
			randomNum[i] = (int)Math.floor(Math.random() * (100 - 1) + 1);
			if (esPar(randomNum[i]))
				pares++;
		}
		System.out.println("Los números generados han sido:");
		for (int i = 0; i < 10; i++)
			System.out.print(randomNum[i] + " ");
		System.out.println("\n" + pares + " de esos números son pares.");
	}
	
	/**
	 * Esta función analiza un número entero recibido y analiza si es par o impar.
	 * 
	 * @param num1
	 * @return boolean par
	 */
	private static boolean esPar(int num1) {
		boolean par;
		if (num1 % 2 == 0)
			par = true;
		else
			par = false;
		return par;
	}
	
	/**
	 * Esta función recibe dos números enteros y devuelve el mayor de los dos. Si fueran iguales devuelve num2.
	 * @param num1
	 * @param num2
	 * @return El número mayor.
	 */
	private static int esMayor(int num1, int num2) {

		if (num1 > num2)
			return (num1);
		else
			return (num2);
	}
	
	private static boolean esPrimo(int num1) {
		boolean primo = true;
	
		if (num1 == 2)
			return (primo);
		else if (num1 < 2 || num1 % 2 == 0) {
			primo = false;
			return (primo);
		}
		//bucle para buscar si hay divisores o si es primo:
		for (int i = 3; i <= Math.sqrt(num1); i += 2) {	//Math.sqrt calcula la raiz cuadrada de un nº
			if (num1 % i == 0) {
            		primo = false; //cuando encuentra un divisor se sabe que NO es primo
            		break;
			}
        }
		return (primo);
	}
	
	private static int suma(int num1, int num2) {
		int	resultado = 0;
		
		return (resultado);
	}
	
	private static int resta(int num1, int num2) {
		int	resultado = 0;
		
		return (resultado);
	}
	
	private static int multiplicacion(int num1, int num2) {
		int	resultado = 0;
		
		return (resultado);
	}
	
	private static int division(int num1, int num2) {
		int	resultado = 0;
		
		return (resultado);
	}
	
	
}
