package ejercicioScanner;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		System.out.println("Pongamos un numerito:");
		String cadena=teclado.nextLine();
		int miEntero= Integer.parseInt(cadena);
		System.out.println("Introduce un número decimal, por favor");
		cadena=teclado.nextLine();
		float miDecimal= Float.parseFloat(cadena);
		System.out.println("Introduce un número double, por favor");
		cadena=teclado.nextLine();
		double miDouble= Double.parseDouble(cadena);
		System.out.println("Introduce un boolean, por favor");
		cadena=teclado.nextLine();
		boolean miboolean= Boolean.parseBoolean(cadena);
		System.out.println(miboolean);
		teclado.close();
	}
}
