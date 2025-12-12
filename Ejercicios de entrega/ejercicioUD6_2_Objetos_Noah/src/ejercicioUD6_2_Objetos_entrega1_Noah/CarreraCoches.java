package ejercicioUD6_2_Objetos_entrega1_Noah;

import java.util.Scanner;

/**
 * Esta clase instancia un objeto de clase Coche, y mantiene en bucle al usuario indicando
 * por teclado su velocidad actual, y pidiendo que indique si debe acelerar o frenar el coche
 * o cerrar el programa.
 */
public class CarreraCoches {

	/**
	 * 	Método main que mantiene el flujo del programa.
	 * @param args
	 */
	public static void main(String args[]) {
		
		int		variacion = 0;
		Coche	cochecito = new Coche();
		Scanner	teclado = new Scanner(System.in);
		String	entrada = "";
		
		do {
			System.out.printf("\nVelocidad actual: %d km/h\n\n", cochecito.getVelocidad());
			do {
				System.out.print("Introduce la variación de la velocidad deseada (0 para finalizar): ");
				entrada = teclado.nextLine();
				
				if (AuxMetods.checkSoloNumeroPositivoEntero(entrada))
					variacion = Integer.parseInt(entrada);
				
			} while (!AuxMetods.checkSoloNumeroPositivoEntero(entrada));
			
			if (variacion < 0)
				cochecito.frena(variacion);
			if (variacion > 0)
				cochecito.acelera(variacion);
			
		} while(variacion != 0);
		
		System.out.println("\nFin");
		
		teclado.close();
	}
}
