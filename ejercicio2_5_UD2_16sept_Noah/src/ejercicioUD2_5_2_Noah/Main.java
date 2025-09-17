package ejercicioUD2_5_2_Noah;

import java.util.Scanner;

public class Main {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static int		num;
	
	public static void main(String[] args) {
		
		teclado.nextLine();
		int opt = Integer.parseInt(entrada);
		
		while (opt !=0) {
			switch (opt) {
			
				case 1,2,3,4,5:
					System.out.println("Solo 6 o 7 por favor.");
					break;
				case 6:
					ejercicio6();
					break;
				case 7:
					ejercicio7();
					break;
			}
			teclado.nextLine();
			opt = Integer.parseInt(entrada);
			while (opt < 0 || opt > 5) {
				System.out.println("Por favor, solo 6 o 7 (o 0 para salir).");
				teclado.nextLine();
				opt = Integer.parseInt(entrada);
			}
		}
	}

	/*6. Leer por pantalla un número del 1 al 7 y mostrar por pantalla
	 * el día de la semana correspondiente.*/
	private static void ejercicio6() {
		System.out.println("Dime un número del 1 al 7:");
		entrada = teclado.nextLine();
		num = Integer.parseInt(entrada);
		switch (num){
		case 1:
			System.out.println("Lunes.");
			break;
		case 2:
			System.out.println("Martes.");
			break;
		case 3:
			System.out.println("Miércoles.");
			break;
		case 4:
			System.out.println("Jueves.");
			break;
		case 5:
			System.out.println("Viernes.");
			break;
		case 6:
			System.out.println("Sábado.");
			break;
		case 7:
			System.out.println("Domingo.");
			break;
		default:
			System.out.println("Dato incorrecto.");
			break;
		}
	}
	
	/*7. Un postulante a un empleo, realiza un test de capacitación, se obtuvo la siguiente información: cantidad total de preguntas que se le realizaron y la cantidad de preguntas que contestó correctamente. Se pide confeccionar un programa que ingrese los dos datos por teclado e informe el nivel del mismo según el porcentaje de respuestas correctas que ha obtenido, y sabiendo que:
			∙Nivel máximo: Porcentaje>=90%.
			∙Nivel medio: Porcentaje>=75% y <90%.
			∙Nivel regular: Porcentaje>=50% y <75%.
			∙Fuera de nivel: Porcentaje<50%.*/
	private static void ejercicio7() {
		System.out.println("¿De cuántas preguntas constaba el test?");
		entrada = teclado.nextLine();
		int numPreguntas = Integer.parseInt(entrada);
		System.out.println(numPreguntas);
		System.out.println("¿Cuántas preguntas se respondieron correctamente?");
		entrada = teclado.nextLine();
		int numAciertos = Integer.parseInt(entrada);
		System.out.println(numAciertos);
		int resultado = (numAciertos / numPreguntas);
		System.out.println(resultado);
		if (numAciertos < 0 || numPreguntas <= 0 || numAciertos > numPreguntas)
			System.out.println("Cálculo no realizado por datos incorrectos.");
		else {
			System.out.print("Su resultado fue un ");
			if (resultado < 50)
				System.out.print(resultado);
			else if (resultado <75)
				System.out.print(resultado);
			else if (resultado <90)
				System.out.print(resultado);
			else 
				System.out.print(resultado);
			System.out.println("% de aciertos en su test.");
		}
	}
}
