package ejercicios1y2_Arrays_Noah;

/**
 * Esta clase desarrolla el ejercicio 1. Se pide adquirir las edades de 20 estudiantes, mostrarlas y calcular y mostrar la media aritmética.
 */
public class EjecutarEjercicio1 {

	/**
	 * Este método crea un array de números enteros para almacenar 20 edades de estudiantes de un hipotético curso.
	 * Permite al usuario elegir si introducir las edades o generarlas de forma aleatoria para testear el output de este ejercicio.
	 * Por último, imprime por pantalla las edades de cada alumno y la media de notas.
	 */
	public static void	ejercicio1() {
		
		int	edades[];
		
		Main12.num = MetodAux.menuOpciones("¿Desea introducir las edades manualmente?", null, "Indique su respuesta");
		
		if (Main12.num == 0)
			edades = recoge20Edades();
		else 
			edades = inventa20Edades();
		
		imprimirEdad(edades);
	}

	/**
	 * Esta función Pide al usuario por teclado que introduzca la edad de un alumno y verifica que los datos de entrada son un número entero
	 * comprendido entre el 18 y el 35, devolviendo un mensaje de error en caso contrario y volviendo a pedirlo hasta que sea correcto.
	 * Cuando ya se ha procesado, devuelve el número entero validado.
	 * @return int edad
	 */
	private static int	leerEdad() {
		
		int		edad = -1;
		boolean	edadValida;
		
		do {
			edadValida = false;
			
			System.out.println("\t- Introduzca la edad:");
			Main12.entrada = Main12.teclado.nextLine().trim();
			
			if (MetodAux.checkSoloNumeroPositivoEntero()) {
				
				edad = Integer.parseInt(Main12.entrada);
			
				if (edad < 18 || edad > 35) {
					System.out.println("Error: los estudiantes de este curso solo pueden tener entre 18 y 35 años.");
					System.out.println("Vuelva a intentarlo.");
				}
				else
					edadValida = true;
			}
			
		} while (!edadValida);
		
		return (edad);
	}
	
	/**
	 * Este método muestra por pantalla un array de números enteros. Recibe por parámetro dicho array.
	 * Va iterando y por cada valor, imprime un mensaje informativo que da contexto y contiene el valor (la edad de un estudiante).
	 * Por último calcula la media y la muestra también por pantalla.
	 * @param edades - un array de números enteros entre 18 y 35.
	 */
	private static void imprimirEdad(int edades[]) {
		
		int	media;
		
		for (int i = 0; i < edades.length; i++) 
			System.out.printf("\t- Edad del estudiante nº %d: %d años.\n\n", i, edades[i]);
		
		media = calcularMedia(edades);
		
		System.out.printf("\t- La media de edad de tus 20 estudiantes es: %d años\n\n", media);
		
	}
	
	/**
	 * Esta función recibe un array de números enteros, realiza la suma de todos ellos y devuelve el resultado de dividirlo entre 
	 * la cantidad total de números de dicho array.
	 * @param numeros - un array de números enteros
	 * @return int media aritmética
	 */
	private static int	calcularMedia(int numeros[]) {
		
		int	total = 0;
		
		for (int i = 0; i < numeros.length; i++) 
			total += numeros[i];

		return (total / numeros.length);
	}
	
	/**
	 * Esta función genera aleatoriamente 20 números enteros entre el 18 y el 35, tras anunciar dicha operación por pantalla,
	 * los almacena en un array de números enteros y devuelve dicho array.
	 * @return  int edades[] - Un array de números enteros generados aleatoriamente que contiene 20 edades entre 18 y 35 años.
	 */
	private static int[] inventa20Edades() {
		
		int	edades[] = new int[20];
		
		System.out.println("\n\n\t- Se procede a generar aleatoriamente las edades de 20 estudiantes ficticios:\n\n");
		for (int i = 0; i < edades.length; i++) 
			edades[i] = (int)Math.floor(Math.random() * (35 - 18 + 1) + 18); //(max - min - 1) + min

		return (edades);
	}
	
	/**
	 * Esta función recoge por teclado 20 números enteros entre el 18 y el 35, tras pedirlo por pantalla uno a uno,
	 * los almacena en un array de números enteros y devuelve dicho array.
	 * @return  int edades[] - Un array de números enteros que contiene 20 edades entre 18 y 35 años.
	 */
	private static int[] recoge20Edades() {
		int	edades[] = new int[20];
		
		for (int i = 0; i < edades.length; i++) {
			System.out.printf("\t¿Cuál es la edad del estudiante nº %d?\n", i + 1);
			edades[i] = leerEdad();
		}
		
		return (edades);
	}
}
