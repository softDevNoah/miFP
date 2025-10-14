package EjercUD5_2_Arrays_Noah;

import java.util.Scanner;

public class MetodAux {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static int		num;
	
	public static boolean decideSioNo() {
		
		boolean	introducirEdades = false;
		do {
			System.out.println("***Solo escriba \"S\" (Sí) o \"N\" (No), por favor.");
			entrada = teclado.nextLine();
			
		}while (checkSN(entrada));
		if(entrada.equals("S"))
			introducirEdades = true;
		return (introducirEdades);
	}
	
	private static boolean checkSN(String entrada) {
		
		if (!entrada.equals("S") && !entrada.equals("N"))
			return (false);
		else
			return (true);
	}
	
	public static int	checkNumPositivo() {
		
		boolean	esNum;
		
		do {
			esNum = true;
			entrada = teclado.nextLine();
			for (int i = 0; i < entrada.length(); i++) {
				if (!Character.isDigit(entrada.charAt(i))) {
					esNum = false;
					break;
				}
				if (!esNum)
					System.out.println("Error: introduzca únicamente un número entero (mayor de 0), por favor.");
			}
		}while (!esNum);
		
		num = Integer.parseInt(entrada);
		return (num);
	}
	
	public static int	calcularMedia(int numeros[]) {
		
		int	total = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			total += numeros[i];
		}
		return (total / numeros.length);
	}
}
