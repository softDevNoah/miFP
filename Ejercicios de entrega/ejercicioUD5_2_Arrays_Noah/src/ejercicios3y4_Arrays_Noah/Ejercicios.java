package ejercicios3y4_Arrays_Noah;

/**
 * Esta clase contiene todos los métodos necesarios para ejecutar los ejercicios 3 y 4 de la entrega de Arrays.
 */
public class Ejercicios {

	/**
	 * Este método contiene el flujo del ejercicio 3.
	 * Declara un array de int que manejará y mostrará por pantalla.
	 */
	public static void	ejecutar3() {
		
		int	tabla[];
		
		tabla = cargarTabla(20, 1, 9);
		mostrarArray(tabla);
		mostrarFrecuencias(tabla);
	}
	
	/**
	 * Este método recibe por parámetros el tablaño de la tabla y los valores máximo y mínimo para cargar dicha tabla.
	 * Los números son generados aleatoriamente.
	 * Este método no valida los parámetros que recibe. Se asume que son válidos.
	 * Finalmente, la devuelve.
	 * 
	 * @param tamaño - número entero que indica el tamaño de la tabla.
	 * @param valorMin - número entero que expresa el valor mínimo para generar valores de la tabla
	 * @param valorMax - número entero que expresa el valor máximo para generar valores de la tabla
	 * @return tabla - array de int del tamaño indicado, con números aleatorios en el rango indicado
	 */
	private static int[] cargarTabla(int tamaño, int valorMin, int valorMax){
		
		int	tabla[] = new int[tamaño];
		
		for (int i = 0; i < tamaño; i++) {
			tabla[i] = generarNumero(valorMin, valorMax);
		}
		
		return (tabla);
	}
	
	/**
	 * Este método recibe un array de int y lo imprime por pantalla.
	 * @param array - array de números enteros
	 */
	private static void mostrarArray(int array[]) {
		
		for (int i = 0; i< array.length; i++) {
			System.out.printf("\tTabla[%d]: %d\n", i, array[i]);
		}
		System.out.println();
	}
	
	/**
	 * Este método cuenta las apariciones de un número dentro de un array de tipo int.
	 * Para ello recorre el array tantas veces como valores se desea contabilizar. En este caso,
	 * como los valores son del 1 al 9, el bucle externo realiza 9 iteraciones, empezando por el 1.
	 * El contador se reinicia con cada iteración de este bucle externo, y recorre el array al completo,
	 * sumando 1 al contador cada vez que encuentra el valor que quiere contabilizar.
	 * Así, cada conteo lo imprime por pantalla con un mensaje antes de pasar al conteo
	 * del siguiente número.
	 * 
	 * @param array - array que contiene n números enteros (int)
	 */
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
	
	/**
	 * Este método genera aleatoriamente un número entero entre el rango indicado por parámentros,
	 * incluyendo los valores mínimo y máximo. Finalmente, devuelve el número generado.
	 * 
	 * @param valorMin - nº entero, valor mínimo del rango
	 * @param valorMax - nº entero, valor máximo del rango
	 * @return número aleatorio generado entre dichos valores
	 */
	private static int generarNumero(int valorMin, int valorMax) {
		int numRandom;
		
		numRandom = (int)Math.floor(Math.random() * (valorMax - valorMin + 1) + valorMin); // (max - min + 1) - min
		
		return (numRandom);
	}
	
	/**
	 * Este método contiene el flujo del ejercicio 4.
	 * Declara un array de tipo String que contiene nombres de alumnos,
	 * otro array de tipo int con las notas de dichos alumnos, y un tercer array, de tipo int, con las estadísticas
	 * generadas por cálculos.
	 * Primero carga los datos por teclado, luego los muestra, realiza los cálculos y muestra los resultados.
	 */
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
	
	/**
	 * Este método crea y carga un array de tipo String con los nombres de 10 estudiantes, recogidos por teclado.
	 * Solamente revisa que la entrada no esté vacía, pero no valida si son caracteres alfabéticos ni si el nombre
	 * contiene los apellidos. 
	 * Finalmente, devuelve el array con los nombres introducidos.
	 * 
	 * @return nombres - array de tipo String con el listado de nombres de los alumnos
	 */
	private static String[] cargarArrayNombres() {//no piden validaciones...
		
		String	nombres[] = new String[10];
		String	entrada;
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.printf("Nombre completo del alumno nº %d: ", i + 1);
			entrada = Main34.teclado.nextLine();
			if (!entrada.isBlank()) {
				nombres[i] = entrada;
				i++;
			}
			i--;
			System.out.println();
		}
		return (nombres);
	}
	
	/**
	 * Este método crea y carga un array de tipo int con las notas de 10 estudiantes, recogidas por teclado.
	 * Valida si la entrada es numérica, entera, y si son notas comprendidas entre 0 y 10.
	 * Finalmente, devuelve el array con las notas introducidas.
	 * 
	 * @return notas - array de tipo int con el listado de notas de los alumnos 
	 */
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
						/* para no repetir i-- en cada caso de error, cuando la entrada esta bien
						 * habra dos veces i++, es decir, una en la iteracion del bucle for, y otra
						 * forzada manual aqui.
						 * La otra alternativa era poner a cada if de validacion, un else con i--,
						 * y esto deriva en mas lineas repetidas.*/
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
	
	/**
	 * Este método muestra por pantalla los nombres y las notas de los alumnos, cuyos datos recibe por
	 * parámetro mediante dos arrays, uno de tipo String y otro de tipo int.
	 * 
	 * @param nombres - array de tipo String de los nombres de los estudiantes
	 * @param notas - array de tipo int con las notas de los estudiantes
	 */
	private static void mostrarTodosDatos(String nombres[], int notas[]) {
		
		for (int i = 0; i < nombres.length; i++) {
			System.out.printf("\tLa nota de %s es un %d.\n", nombres[i], notas[i]);
		}
		System.out.println();
	}	
	
	/**
	 * Este método recibe los arrays con los nombres y las notas de los estudiantes, realiza cálculos
	 * estadísticos (la media, la peor y la mejor nota, y a quienes corresponden) y devuelve los 
	 * resultados contenidos dentro de un array de int.
	 * 
	 * @param nombres - array de Strings con los nombres de los estudiantes
	 * @param notas - array de ints con las notas de los estudiantes
	 * @return estadisticas - array de tipo int con los valores obtenidos y los índices de los alumnos que corresponde
	 */
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
	
	/**
	 * Este método muestra por pantalla los valores estadísticos calculados de forma explicativa, usando los arrays que recibe
	 * por parámetro.
	 * 
	 * @param nombres - array de Strings con los nombres de los estudiantes
	 * @param estadisticas - array con los resultados de los cálculos y los índices de los alumnos dentro de su array
	 */
	private static void mostrarEstadisticas(String nombres[], int estadisticas[]) {
		
		System.out.printf("La nota media de la clase ha sido un %d.\n", estadisticas[0]);
		System.out.printf("La peor nota de la clase ha sido un %d, de %s.\n", estadisticas[1], nombres[estadisticas[3]]);
		System.out.printf("La mejor nota de la clase ha sido un %d, de %s.\n", estadisticas[2], nombres[estadisticas[4]]);
		
	}
	
	/**
	 * Este método se encarga de recibir un listado de números enteros y calcular la media. Finalmente, la devuelve.
	 * 
	 * @param numeros - listado de números enteros
	 * @return media aritmética obtenida 
	 */
	private static int	calcularMedia(int numeros[]) {
	
		int	total = 0;
		
		for (int i = 0; i < numeros.length; i++) {
			total += numeros[i];
		}
		return (total / numeros.length);
	}	
	
}
