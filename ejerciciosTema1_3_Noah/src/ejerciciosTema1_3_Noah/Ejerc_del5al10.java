package ejerciciosTema1_3_Noah;

import java.util.Scanner;

//en este archivo están los programas que había que crear en los apartados 5, 6, 7, 8, 9 y 10.

public class Ejerc_del5al10 {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;	
	
	public static void main(String[] args) {

		System.out.println("Ejercicio 5: ");
		ejercicio5();
		System.out.println("\nEjercicio 6: ");
		ejercicio6();
		System.out.println("\nEjercicio 7: ");
		ejercicio7();
		System.out.println("\nEjercicio 8: ");
		ejercicio8();
		System.out.println("\nEjercicio 9: ");
		ejercicio9();
		System.out.println("\nEjercicio 10: ");
		ejercicio10();
		teclado.close();
	}
	
	/*5. Realiza un programa en Java que calcule la longitud de una circunferencia de radio de 3 metros y la muestre por pantalla.*/
	private static void ejercicio5() {
		
		double	radio=3;
		double	diametro = radio * 2;
		double	longitud = diametro * 3.1415;
		
		System.out.println("La longitud de una circunsferencia de 3 metros de radio es: " + longitud + " metros.");
	}

	/*6. Realiza un programa en Java que calcule el área de una circunferencia de radio 5,2 centímetros y la muestre por pantalla.*/
	private static void ejercicio6() {
		
		double	radio=5.2;
		double	area = (radio + radio) * 3.1415;
		
		System.out.println("El área de una circunsferencia de 5,2 centímetros de radio es: " + area + " centímetros.");
	}

	/*7. Realiza un programa en Java que dada dos variables a y b, intercambie los valores de a y b.*/
	private static void ejercicio7() {
		
		int a, b, tmp;
		a = 40;
		b = 77;
		
		System.out.println("A es "+ a + " y B es " +b);
		
		tmp = a;
		a = b;
		b = tmp;
		
		System.out.println("Se intercambiaron los valores.");
		System.out.println("Ahora A es "+ a + " y B es " +b);
	}
	
	/*8. Hacer un programa para sumar dos números leídos por teclado y escribir el resultado.*/
	private static void ejercicio8() {
	
		int num1, num2, suma;
		
		System.out.println("Escriba dos números, uno después del otro por favor:");
		
		entrada = teclado.nextLine();
		num1=Integer.parseInt(entrada);		//num1 cogerá el valor leido desde teclado
		
		entrada = teclado.nextLine();	
		num2 = Integer.parseInt(entrada);	//num2 cogerá el valor leido desde teclado
		
		suma = num1 + num2;
		System.out.println("La suma de los numeros "+ num1 + " y " + num2 + " da: "+suma);
		
	}
	
	/*9. Hacer programa que permita leer 2 números diferentes y nos diga cuál es el mayor de los 2 números.*/
	private static void ejercicio9() {
		
		int a, b;
		
		System.out.println("Escriba dos números, uno después del otro por favor:");
		
		entrada = teclado.nextLine();
		a=Integer.parseInt(entrada);
		
		entrada = teclado.nextLine();
		b=Integer.parseInt(entrada);
		
		if (a == b)
			System.out.println("Son iguales.");
		else {
			if (a < b)
				System.out.println(b + " es el mayor de los dos.");
			else
				System.out.println(a + " es el mayor de los dos.");
		}
			
	}
	
	/*10. Crear un programa en el que se almacenen 3 números en 3 variables A, B y C. Se debe mostrar decidir cuál es el mayor y cuál
	 * es el menor. (En caso de ser los mayores o menos iguales se mostrará uno de ellos)*/
	private static void ejercicio10() {
	
		int a, b, c;
		
		System.out.println("Escriba tres números, uno después del otro por favor:");
		
		entrada = teclado.nextLine();
		a=Integer.parseInt(entrada);
		entrada = teclado.nextLine();
		b=Integer.parseInt(entrada);
		entrada = teclado.nextLine();
		c=Integer.parseInt(entrada);
		
		if (a == b && a == c)
			System.out.println("Los tres números son iguales.");
		else {
			if (a >= b && a >= c) {
				System.out.print("El mayor es " + a + " y el menor es ");
				if (b > c)
					System.out.println(c);
				else
					System.out.println(b);
			}
			else if (b >= a && b >= c) {
				System.out.print("El mayor es " + b + " y el menor es ");
				if (a > c)
					System.out.println(c);
				else
					System.out.println(a);
			}
			else {
				System.out.print("El mayor es " + c + " y el menor es ");
				if (b > a)
					System.out.println(a);
				else
					System.out.println(b);
			}
		}
		
	}

}
