package ejercicio2_5_UD2_16sept_Noah;

import java.util.Scanner;

public class Main {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static int		num;
	
	public static void main(String[] args) {
		
		//ejercicio1();
		//ejercicio2();
		//ejercicio3();
		//ejercicio4();
		//ejercicio5();
		//ejercicio6();
		ejercicio7();
	}

	/*1. Ingresar el sueldo de una persona, si supera los
	 * 3000 euros mostrar un mensaje en pantalla indicando que
	 * debe abonar impuestos.*/
	private static void ejercicio1() {
		System.out.println("Escribe un salario:");
		entrada = teclado.nextLine();
		num = Integer.parseInt(entrada);
		if (num > 3000)
			System.out.println("Debe abonar impuestos");
		else
			System.out.println("No debe abonar impuestos.");
	}
	
	/*2. Pedir la edad por teclado y decir si es mayor de edad o no.*/
	private static void ejercicio2() {
		System.out.println("Dime tu edad:");
		entrada = teclado.nextLine();
		num = Integer.parseInt(entrada);
		if (num >= 18)
			System.out.println("Eres mayor de edad.");
		else
			System.out.println("Eres menor de edad.");
	}
	/*3. Pedir una nota por teclado y mostrar un mensaje en pantalla con la nota en formato texto, en función del rango que se muestra a continuación:
			● 1-2: Necesita mejorar
			● 3-4: Necesita afianzar
			● 5: Suficiente
			● 6: Bien
			● 7-8: Muy bien
			● 9-10: Perfecto
			● Resto de opciones: Dato incorrecto.*/
	private static void ejercicio3() {
		System.out.println("¿Qué nota me das?");
		entrada = teclado.nextLine();
		num = Integer.parseInt(entrada);
		
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
	
	/*4. Pedir tres números por teclado y mostrar en pantalla el mayor de los tres.*/
	private static void ejercicio4() {
		//un array para simplificar líneas de códico usando un for para asignar valores a tres int
		int nums[] = {0,0,0};
		for (int iter=0; iter < 3; iter++) {
			System.out.println("Dame un número:");
			entrada = teclado.nextLine();
			nums[iter] = Integer.parseInt(entrada);
		}
		if (nums[0] == nums[1] && nums[0] == nums[2])
			System.out.println("Oye, que son todos iguales...");
		//sea igual alguno entre si o no, se mira si el num1 es el mayor
		else if (nums[0] >= nums[1] && nums[0] >= nums[2])
			//estas lineas de abajo sobran si pongo ">=" en vez de solo ">" en la condicion de arriba:
				/*|| (nums[0] == nums[1] && nums[0] > nums[2])
				//|| (nums[0] == nums[2] && nums[0] > nums [1]))*/
			System.out.println(nums[0] +" es el mayor de los tres números.");
		//sea igual alguno entre si o no, se mira si el num2 es el mayor
		else if (nums[1] >= nums[0] && nums[1] >= nums[2])
				//aqui sucede los mismo que antes:
				/*|| (nums[1] == nums[0] && nums[1] > nums[2])
				//|| (nums[1] == nums[2] && nums[1] > nums [0]))*/
			System.out.println(nums[1] +" es el mayor de los tres números.");
		//todos los casos revisados, solo puede ser el num3:
		else
			System.out.println(nums[2] +" es el mayor de los tres números.");
		}
	
	//5. Realizar el ejercicio 3 utilizando la estructura Switch.
	private static void ejercicio5() {
		System.out.println("¿Qué nota me das?");
		entrada = teclado.nextLine();
		num = Integer.parseInt(entrada);
		switch (num){
		case 1,2:
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
