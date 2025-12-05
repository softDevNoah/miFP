package ejercicioUD3_2_1_Noah;

import java.util.Scanner;

public class Funciones {

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
					if (num1 >= 1) {
						System.out.println("Se procede a generar los primeros " + num1 + " números primos:");
						muestraPrimos(num1);
					}
					else
						System.out.println("Error: debe ser un nº igual o mayor que 1.");
					break;
				case 5:
					calculadora();
					break;
				}

		} while (opt != 0);
		System.out.println("\n_______________________________________________");
		System.out.println("El programa se ha cerrado satisfactoriamente.");
		teclado.close();
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
	
	//ejercicio 1
	/**
	 * Este método analiza un número entero recibido y analiza si es par o impar.
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
	
	//ejercicio 2
	/**
	 * Este método genera diez números enteros aleatorios entre el 1 y el 100 y cuenta cuántos de ellos son pares.
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
	
	//ejercicio 3
	/**
	 * Este método recibe dos números enteros y devuelve el mayor de los dos. Si fueran iguales devuelve num2.
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
	
	//ejercicio 4_1
	/**
	 * Este método recibe un número entero y analiza si es primo o no. 
	 * @param num
	 * @return Boolean primo
	 */
	private static boolean esPrimo(int num) {
		boolean primo = true;
	
		if (num == 2)
			return (primo);
		else if (num < 2 || num % 2 == 0) {
			primo = false;
			return (primo);
		}
		//bucle para buscar si hay divisores o si es primo:
		for (int i = 3; i <= Math.sqrt(num); i += 2) {	//Math.sqrt calcula la raiz cuadrada de un nº
			if (num % i == 0) {
            		primo = false; //cuando encuentra un divisor se sabe que NO es primo
            		break;
			}
        }
		return (primo);
	}
	
	//ejercicio 4_2
	/**
	 * Este método recibe un número y genera esa cantidad de números primos por pantalla.
	 * Utiliza el método esPrimo(int num) internamente.
	 * @param cantidad
	 */
	private static void muestraPrimos(int cantidad) {
		int	primos = 0;
		int num = 0;
		
		while(primos < cantidad) {
		
			//lo divido en dos condiciones para imprimirlo más 'elegante'
			if(esPrimo(num) && primos < (cantidad - 1)) {
				System.out.print(num + ", ");
				primos++;
			}
			else if(esPrimo(num) && primos >= (cantidad - 1)) {
				System.out.print(num + ".");
				primos++;
			}
			num++;
		}
	
		/*
		for (int num = 0; primos < num1; num++) {
			if (esPrimo(num)) {
				System.out.print(n + " ");
				primos++;
			}
		}*/
	}
	
	//ejercicio 5
	/**
	 * Este método es una pequeña y sencilla calculadora, que recoge números enteros desde el teclado
	 * y despliega un menú de operaciones y según se seleccione, ejecuta dicha operación.
	 * Si no recibe un número entero, volverá a pedir un número.
	 */
	private static void calculadora() {
		int		num1, num2, opcDeseada;
		
		do {
			System.out.print("*****************\n\nCalculadora\n\n*****************\n");
			System.out.print("\t\t1. Suma\n"
							+ "\t\t2. Resta\n"
							+ "\t\t3. Producto\n"
							+ "\t\t4. División\n"
							+ "\t\t5. Salir\n");
		
			opcDeseada = checkNum();

			if (opcDeseada < 1 || opcDeseada > 5) {//primero se analiza si sale de los márgenes 
		
				do {
					System.out.printf("Opción %d no disponible, vuelva a intentarlo.\n", opcDeseada);	
					opcDeseada = checkNum();
					
				} while (opcDeseada < 1 || opcDeseada > 5);	//si sale de los márgenes, se queda en bucle hasta que sea un valor valido
			}
			
			if (opcDeseada != 5) { //si opcDeseada == 5, se sale directamente de aqui
			
				num1 = checkNum();
				num2 = checkNum();		
				System.out.print("Operación seleccionada: ");
				switch (opcDeseada) {	
					case 1:
						suma(num1, num2);
						System.out.printf("Suma.\n%d + %d = %d", num1, num2, suma(num1, num2));
						break;
					case 2:
						resta(num1, num2);
						System.out.printf("Resta.\n%d - %d = %d", num1, num2, resta(num1, num2));
						break;
					case 3:
						multiplicacion(num1, num2);
						System.out.printf("Producto.\n%d * %d = %d", num1, num2, multiplicacion(num1, num2));
						break;
					case 4:
						if (num2 != 0) {
							division(num1, num2);
							System.out.printf("División.\n%d / %d = %d", num1, num2, division(num1, num2));
						}
						else
							System.out.println("Error, un número no puede dividirse entre 0"); //unico caso imposible de division
						break;
				}
			}
			System.out.println();
		} while (opcDeseada != 5);
		System.out.println("Se ha cerrado la calculadora adecuadamente.");
	}
	
	//ejercicio 5 - suma
	/**
	 * Este método recibe dos enteros como parámetros y devuelve la suma de ambos números.
	 * @param num1
	 * @param num2
	 * @return resultado
	 */
	private static int suma(int num1, int num2) {
		int	resultado = num1 + num2;
		return (resultado);
	}
	
	//ejercicio 5 - resta
	/**
	 * Este método recibe dos enteros como parámetros y devuelve la diferencia entre ambos números.
	 * @param num1
	 * @param num2
	 * @return resultado
	 */
	private static int resta(int num1, int num2) {
		int	resultado = num1 - num2;
		return (resultado);
	}
	
	//ejercicio 5 - producto
	/**
	 * Este método recibe dos enteros como parámetros y devuelve el producto de ambos números.
	 * @param num1
	 * @param num2
	 * @return resultado
	 */
	private static int multiplicacion(int num1, int num2) {
		int	resultado = num1 * num2;
		
		return (resultado);
	}
	
	//ejercicio 5 - división
	/**
	 * Este método recibe dos enteros como parámetros y devuelve la división entre ambos números.
	 * @param num1
	 * @param num2
	 * @return resultado
	 */
	private static int division(int num1, int num2) {
		int	resultado = num1 / num2;
		
		return (resultado);
	}
	
	
}
