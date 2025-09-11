package ejercicioImprovisado;

import java.util.*;

public class CalcularElCubo {

	public static void main(String[] args) {

		/*programa para calcular y mostrar por pantalla el
		cubo de un numero recogido por el teclado*/
		System.out.println("Te calculo el cubo:");
		
		Scanner entrada = new Scanner(System.in);
		String linea = entrada.nextLine();
		
		//se parsea el tipo de dato y se realiza el calculo
		int numerito = Integer.parseInt(linea);
		int result = numerito * numerito * numerito;
		
		//se imprime el resultado
		System.out.println("Ese numerito, al cubo da: " + result);
		
		//siempre se debe cerrar la entrada de datos del scanner
		entrada.close();
	}
}
