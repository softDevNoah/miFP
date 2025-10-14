package EjercUD5_2_Arrays_Noah;

import java.util.Scanner;

public class EjercUD5_2_1_Arrays_Noah {

	private static Scanner	teclado = new Scanner(System.in);
	private static String	entrada;
	private static int		num;
	
		
	public static void	main(String[] args) {
		
		int	edades[] = new int[20];
		
		
		System.out.println("¿Desea introducir manualmente las edades de sus 20 estudiantes?");
		
		if (decideSioNo())
			edades = recoge20Edades();
		else
			edades = inventa20Edades();
		
		imprimirEdad(edades);
	}

	private static boolean decideSioNo() {
		
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
	
	private static int	checkNum() {
		
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
	
	private static int	generaEdadRandom() {
		
	}
	
	private static int[] inventa20Edades() {
		
		int	edades[] = new int[20];
		
		System.out.println("Se procede a generar aleatoriamente las edades de 20 estudiantes ficticios:");
		for (int i = 0; i < edades.length; i++) {
			edades[i] = generaEdadRandom();
		}
		return (edades);
	}
	
	private static int	leerEdad() {
		
		int		edad;
		boolean	edadValida;
		
		do {
			System.out.println("Introduzca la edad:");
			edad = checkNum();
			edadValida = true;
			if (edad < 18 || edad > 35) {
				System.out.println("Error: los estudiantes de este curso solo pueden tener entre 18 y 35 años.");
				System.out.println("Vuelva a intentarlo.");
				edadValida = false;
			}
		}while (!edadValida);
		return (edad);
	}
	
	private static int[] recoge20Edades() {
		int	edades[] = new int[20];
		
		for (int i = 0; i < edades.length; i++) {
			System.out.printf("¿Cuál es la edad del estudiante nº %i?", edades[i]);
			edades[i] = leerEdad();
		}
		
		return (edades);
	}
	
	private static int	calcularMedia(int edades[]) {
		
		int	total = 0;
		
		for (int i = 0; i < edades.length; i++) {
			total += edades[i];
		}
		return (total / edades.length);
	}
	
	private static void imprimirEdad(int edades[]) {
		
		int	media;
		
		for (int i = 0; i < edades.length; i++) {
			System.out.printf("El/la alumno/a nº %i de la lista tiene %d años.\n", i, edades[i]);
		}
		
		media = calcularMedia(edades);
		
		System.out.printf("La media de edad de tus 20 estudiantes es: %i", media);
		
	}
	
	
}
