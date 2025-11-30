package ejercicios3y4_Arrays_Noah;

public class Ejercicios {

	public static void	ejecutar3() {
		
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
	
	public static void ejecutar4() {
		
		String	nombres[];
		int		notas[];
		int		estadisticas[];
		
		
		nombres = cargarArrayNombres();
		notas = cargarArrayNotas();
		
		mostrarTodosDatos(nombres, notas);
		estadisticas = calculoDatos(nombres, notas);
		mostrarEstadisticas(nombres, estadisticas);
		
	}
	
	
	private static String[] cargarArrayNombres() {
		
		String	nombres[] = new String[10];
		String	entrada;
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.printf("Nombre completo del alumno nº %d: ", i + 1);
			entrada = Main34.teclado.nextLine();
			if (entrada.isBlank())
				i--;
			nombres[i] = entrada;	
			System.out.println();
		}
		return (nombres);
	}
	
	private static int[] cargarArrayNotas() {
		
		int		notas[] = new int[10];
		String	entrada;
		int		num;
		
		for (int i = 0; i < notas.length; i++) {
			System.out.printf("Nota del alumno nº %d: ", i + 1);
			entrada = Main34.teclado.nextLine();
			num = -1;
			if (!entrada.isBlank()) {
				if (Main34.checkSoloNumeroPositivoEntero(entrada)) {
					num = Integer.parseInt(entrada);
					if (num < 0 || num > 10)
						num = -1;
					else {
						notas[i] = num;
						i++;
					}
				}
			}
			if (num == -1)
				System.out.println("\t----->>>> Error: solo números del 0 al 10, por favor.");
			i--;
			System.out.println();
		}
		return (notas);
	}
	
	private static void mostrarTodosDatos(String nombres[], int notas[]) {
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.printf("\tLa nota de %s es un %d.\n", nombres[i], notas[i]);
		}
		System.out.println();
	}	
	
	private static int[] calculoDatos(String nombres[], int notas[]) {
		
		int	media = 0, menor = 10, mayor = 0, alumnoPeor = 0, alumnoMejor = 0;
		
		int	estadisticas[] = new int[5];
		
		media = calcularMedia(notas);

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
		System.out.printf("La mejor nota de la clase ha sido un %d, de %s.\n", estadisticas[2], nombres[estadisticas[4]]);
		
	}
	
	private static int	calcularMedia(int numeros[]) {
	
		int	total = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			total += numeros[i];
		}
		return (total / numeros.length);
	}	
	
}
