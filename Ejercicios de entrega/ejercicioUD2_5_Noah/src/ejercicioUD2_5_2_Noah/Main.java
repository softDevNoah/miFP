package ejercicioUD2_5_2_Noah;

import java.util.Scanner;

/*Entrega 2 de 4 (5 contando con los ejercicios extra) de los ejercicios del Tema 2.
 * En este paquete se desarrollan los ejercicios 6 y 7*/

public class Main {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static String	numEjercicio;
	private static int		num;
	
	public static void main(String[] args) {
		
		int opt;
		
		System.out.println("Escribe 6 o 7 (o 0 para salir).");
		
		numEjercicio = teclado.nextLine();
		opt = Integer.parseInt(numEjercicio);
		
		while (opt !=0) {
			switch (opt) {
				case 6:
					ejercicio6();
					break;
				case 7:
					ejercicio7();
					break;
			}
			if (opt != 0) {
				System.out.println("-------------------------------------------------------------------------------------");
				System.out.println("Escribe 6 o 7 (o 0 para salir).");
				numEjercicio = teclado.nextLine();
				opt = Integer.parseInt(numEjercicio);
			}
		}
		teclado.close();
	}

	private static void ejercicio6() {
	/*6. Leer por pantalla un número del 1 al 7 y mostrar por pantalla el día de la semana correspondiente.*/
		
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
				System.out.println("Dato incorrecto.");	//cualquier otro valor de entrada es incorrecto
				break;
		}
	}
		
	private static void ejercicio7() {
		/*7. Un postulante a un empleo, realiza un test de capacitación, se obtuvo la siguiente información: cantidad total
		 * de preguntas que se le realizaron y la cantidad de preguntas que contestó correctamente. Se pide confeccionar un
		 * programa que ingrese los dos datos por teclado e informe el nivel del mismo según el porcentaje de respuestas
		 * correctas que ha obtenido, y sabiendo que:
			∙Nivel máximo: Porcentaje>=90%.
			∙Nivel medio: Porcentaje>=75% y <90%.
			∙Nivel regular: Porcentaje>=50% y <75%.
			∙Fuera de nivel: Porcentaje<50%.*/
		
		double	numPreguntas;
		double	numAciertos;
		double	resultado;
		//las variables son de tipo Double para abarcar resultados que no sean enteros, p. ej 5aciertos/9preguntas
		
		System.out.println("¿De cuántas preguntas constaba el test?");
		entrada = teclado.nextLine();
		numPreguntas = Double.parseDouble(entrada);
		
		System.out.println("¿Cuántas preguntas se respondieron correctamente?");
		entrada = teclado.nextLine();
		numAciertos = Double.parseDouble(entrada);
		
		resultado = (numAciertos / numPreguntas) * 100;
	
		if (numAciertos < 0 || numPreguntas <= 0 || numAciertos > numPreguntas)
			System.out.println("Cálculo no realizado por datos incorrectos.");	//se revisa si los datos son válidos primero
		else {
			System.out.print("Su resultado fue un ");
			if (resultado < 50)
				System.out.printf("%.2f", resultado);
			else if (resultado < 75)
				System.out.printf("%.2f", resultado);
			else if (resultado < 90)
				System.out.printf("%.2f", resultado);
			else 
				System.out.printf("%.2f", resultado);
			System.out.println("% de aciertos en su test.");
		}
	}
}
