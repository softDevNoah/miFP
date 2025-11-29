package ejercicios3y4_Arrays_Noah;

import java.util.Scanner;

public class EjecutarEjercicio34 {

	public static void	ejercicio3() {
		
		int	tabla[];
		
		tabla = cargarTabla(20, 1, 9);
		mostrarArray(tabla);
		mostrarFrecuencias(tabla);
	}
	
	private static int[] cargarTabla(int tamaño, int valorMin, int valorMax){
		
		int	tabla[] = new int[tamaño];
		
		for (int i = 0; i < tamaño; i++) {
			tabla[i] = generarNumero(valorMin, valorMax);
		}
		
		return (tabla);
	}
		
	private static void mostrarArray(int array[]) {
		
		for (int i = 0; i< array.length; i++) {
			System.out.printf("\tTabla[%d]: %d\n", i, array[i]);
		}
		System.out.println();
	}
	
	private static void mostrarFrecuencias(int array[]) {
		
		int contador;
		
		for (int i = 1; i < 10; i++) {
			contador = 0;
			for (int j = 0; j < array.length; j++) {
				if (array[j] == i)
					contador++;
			}
			System.out.printf("\tEl nº %d ha aparecido %d veces.\n", i, contador);
		}
		System.out.println();
	}
	
	private static int generarNumero(int valorMin, int valorMax) {
		int numRandom;
		
		numRandom = (int)Math.floor(Math.random() * (valorMax - valorMin + 1) + valorMin); // (max - min + 1) - min
		
		return (numRandom);
	}
	
	public static void ejercicio4() {
		
		String	nombres[];
		int		notas[] = new int[10];
		int		estadisticas[];
		
		
		nombres = cargarArrayNombres();
		notas = cargarArrayNotas();
		
		mostrarTodosDatos(nombres, notas);
		estadisticas = calculoDatos(nombres, notas);
		mostrarEstadisticas(nombres, estadisticas);
		
	}
	
	
	private static void mostrarTodosDatos(String nombres[], int notas[]) {
		
		for (int i = 0; i < 10; i++) {
			System.out.printf("\tLa nota de %s es un %d.\n", nombres[i], notas[i]);
		}
		System.out.println();
	}
	
	private static String[] cargarArrayNombres() {
		
		Scanner	teclado = new Scanner(System.in);
		String	nombres[] = new String[10];
		String	entrada;
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.printf("Por favor, introduzca nombre completo del alumno nº %d de la lista: ", i + 1);
			entrada = teclado.nextLine();
			if (!entrada.isBlank())
				nombres[i] = entrada;
			else
				i--;
			System.out.println();
		}
		teclado.close();
		return (nombres);
	}
	
	private static int[] cargarArrayNotas() {
		
		Scanner	teclado = new Scanner(System.in);
		int		notas[] = new int[10];
		String	entrada;
		int		num;
		
		for (int i = 0; i < notas.length; i++) {
			System.out.printf("Por favor, introduzca la nota del alumno nº %d de la lista: ", i + 1);
			entrada = teclado.nextLine();
			
			if (!entrada.isBlank()) {
				if (entrada.length() == 1 && Character.isDigit(entrada.charAt(i))) {
					num = Integer.parseInt(entrada);
					if (num < 0 || num > 10)
						num = -1;
					else
						i++;
				}
			}
			i--;
			System.out.println();
		}
		teclado.close();
		return (notas);
	}
	
	private static int[] calculoDatos(String nombres[], int notas[]) {
		
		int	media = 0;
		int	menor = 10;
		int	mayor = 0;
		int	alumnoPeor = 0;
		int	alumnoMejor = 0;
		
		int	estadisticas[] = new int[5];
		
		media = MetodAux.calcularMedia(notas);

		for (int i = 0; i < notas.length; i++){
			if (notas[i] > mayor)
				mayor = notas[i];
			else if (notas[i] < menor)
				menor = notas[i];
		}
		
		for (int i = 0; i < nombres.length; i++) {
			
			if (notas[i] == menor)
				alumnoPeor = i;
			else if (notas[i] == mayor)
				alumnoMejor = i;
		}
		estadisticas[0] = media;
		estadisticas[1] = menor;
		estadisticas[2] = mayor;
		estadisticas[3] = alumnoPeor;
		estadisticas[4] = alumnoMejor;
		return (estadisticas);
	}
	
	private static void mostrarEstadisticas(String nombres[], int estadisticas[]) {
		
		System.out.printf("La nota media de la clase ha sido un %d.\n", estadisticas[0]);
		System.out.printf("La peor nota de la clase ha sido un %d, de %s.\n", estadisticas[1], nombres[estadisticas[3]]);
		System.out.printf("La mejor nota de la classe ha sido un %d, de %s.\n", estadisticas[2], nombres[estadisticas[4]]);
		
	}
}
