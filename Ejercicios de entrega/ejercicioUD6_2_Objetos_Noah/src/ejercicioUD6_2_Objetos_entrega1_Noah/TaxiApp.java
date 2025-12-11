package ejercicioUD6_2_Objetos_entrega1_Noah;

import java.util.Scanner;

/**
 * Esta sencilla clase contiene un programa sin validaciones (se asume que los datos 
 * introducidos son correctos, del tipo adecuado) que crea un objeto Taxi y le asigna
 * los valores introducidos por el usuario por teclado.
 * Luego imprime por pantalla los datos del Taxi y se termina.
 */
public class TaxiApp {

	/**
	 * Método main con el funcionamiento del pequeño programa. Crea un objeto, le asigna
	 * valores, los muestra y se termina.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		Scanner	teclado = new Scanner(System.in);
		Taxi	miTaxi;
		
		String	matricula,	municipio;
		int		tipoMotor;

		AuxMetods.pintarLinea("~", 71);
		
		System.out.print("\tPor favor inserta la matrícula del nuevo taxi: ");
		matricula = teclado.nextLine();
		System.out.print("\tPor favor inserta el municipio del nuevo taxi: ");
		municipio = teclado.nextLine();
		do {
			System.out.print("\tPor favor inserta el tipo de motor del nuevo taxi: ");
			tipoMotor = teclado.nextInt();
		} while (tipoMotor < 0 || tipoMotor > 2);
		
		miTaxi = new Taxi(matricula, municipio, tipoMotor);
		
		AuxMetods.pintarLinea("~", 71);
		
		System.out.println("\n\tEstos son los datos de su taxi:");
		System.out.printf("\t\t- Matricula = %s.\n", miTaxi.getMatricula());
		System.out.printf("\t\t- Municipio = %s.\n", miTaxi.getMunicipio());
		System.out.printf("\t\t- Tipo de motor: %s", miTaxi.getTipoMotor());
		
		AuxMetods.pintarLinea("~", 71);
		teclado.close();
	}

}
