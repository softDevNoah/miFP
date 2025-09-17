package ejercicioUD2_5_1_Noah;

import java.util.Scanner;

public class Main {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static int		num;
	
	public static void main(String[] args) {
		
		teclado.nextLine();
		int opt = Integer.parseInt(entrada);
		
		/*mientras se ponga un numero entre el 1 y el 5, se mantiene
		 * abierto ejecutando los ejercicios que se indiquen, gracias a usar
		 * un while y dentro un switch*/ 
		while (opt !=0) {
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
			}
			teclado.nextLine();
			opt = Integer.parseInt(entrada);
			while (opt < 0 || opt > 5) {
				System.out.println("Por favor, solo un número del 1 al 5 (o 0 para salir).");
				teclado.nextLine();
				opt = Integer.parseInt(entrada);
			}
		}
		teclado.close();
	}

	private static void ejercicio1() {
	/*1. Ingresar el sueldo de una persona, si supera los
	 * 3000 euros mostrar un mensaje en pantalla indicando que
	 * debe abonar impuestos.*/	
		
		System.out.println("Escribe un salario:");
		
		entrada = teclado.nextLine();
		num = Integer.parseInt(entrada);
		if (num > 3000)
			System.out.println("Debe abonar impuestos");
		else
			System.out.println("No debe abonar impuestos.");
	}
	
	private static void ejercicio2() {
	/*2. Pedir la edad por teclado y decir si es mayor de edad o no.*/	
	
		System.out.println("Dime tu edad:");
		
		entrada = teclado.nextLine();
		num = Integer.parseInt(entrada);
		if (num >= 18)
			System.out.println("Eres mayor de edad.");
		else
			System.out.println("Eres menor de edad.");
	}
	
	private static void ejercicio3() {
	/*3. Pedir una nota por teclado y mostrar un mensaje en pantalla con la nota en formato texto, en función del rango que se muestra a continuación:
			● 1-2: Necesita mejorar
			● 3-4: Necesita afianzar
			● 5: Suficiente
			● 6: Bien
			● 7-8: Muy bien
			● 9-10: Perfecto
			● Resto de opciones: Dato incorrecto.*/	
		
		System.out.println("¿Qué nota me das?");
		
		entrada = teclado.nextLine();
		num = Integer.parseInt(entrada);
		//en el ejercicio 3 lo realizo con if porque el ejercicio 5 lo requiere con switch 
		if (num == 1 || num == 2)
			System.out.println("Necesita mejorar.");
		else if (num == 3 || num == 4)
			System.out.println("Necesita afianzar.");
		else if (num == 5)
			System.out.println("Suficiente.");
		else if (num == 6)
			System.out.println("Bien.");
		else if (num == 7 || num == 8)
			System.out.println("Muy bien.");
		else if (num == 9 || num == 10)
			System.out.println("Perfecto.");
		else
			System.out.println("Dato incorrecto.");
	}
	
	private static void ejercicio4() {
	/*4. Pedir tres números por teclado y mostrar en pantalla el mayor de los tres.*/	
		
	/*aunque no pide especificamente usar un array (aun no lo hemos visto en clase)
	 * lo he usado para repasar lo que sabia sobre ellos, para poder poner en práctica
	 * el uso de la estructura de control repetitiva for*/

		int nums[] = {0,0,0};	//aqui declaro e inicializo con valor 0 un array de tres int
	
		/*aqui uso un for para iterar tres veces, leer cada vez un numero del teclado y 
		 * asignarlo a cada int del array, en orden secuencial */
		for (int iter=0; iter < 3; iter++) {
			System.out.println("Dame un número:");
			entrada = teclado.nextLine();
			nums[iter] = Integer.parseInt(entrada);/*en esta linea es donde se guarda el numero
						 							leido en la posicion actual del array*/
		}
		if (nums[0] == nums[1] && nums[0] == nums[2])
			System.out.println("Oye, que son todos iguales...");
		else if (nums[0] >= nums[1] && nums[0] >= nums[2])
			/*el >= y no solo > es para abarcar casos con uno de los numeros repetidos*/
			System.out.println(nums[0] +" es el mayor de los tres números.");
		else if (nums[1] >= nums[0] && nums[1] >= nums[2])
			System.out.println(nums[1] +" es el mayor de los tres números.");
		//todos los casos revisados, el mayor solo puede ser el num3:
		else
			System.out.println(nums[2] +" es el mayor de los tres números.");
		}
	
	
	private static void ejercicio5() {
	//5. Realizar el ejercicio 3 utilizando la estructura Switch.
		
		System.out.println("¿Qué nota me das?");
		
		entrada = teclado.nextLine();
		num = Integer.parseInt(entrada);
		
		switch (num){
			case 1,2:	//se puede poner varios case en la misma linea, separados por ',' 
				System.out.println("Necesita mejorar.");
				break;
			case 3,4:
				System.out.println("Necesita afianzar.");
				break;
			case 5:
				System.out.println("Suficiente.");
				break;
			case 6:
				System.out.println("Bien.");
				break;
			case 7,8:
				System.out.println("Muy bien.");
				break;
			case 9,10:
				System.out.println("Perfecto.");
				break;
			default:
				System.out.println("Dato incorrecto.");
				break;
		}
	}
}
